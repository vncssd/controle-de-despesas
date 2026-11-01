# Especificação Técnica — API Controle de Despesas

## 1. Objetivo do Projeto
Fornecer uma API REST para gerenciamento financeiro pessoal, com foco no controle de despesas à vista e parceladas, cálculo automatizado de juros (simples e compostos) e parcelas, servindo de base para futuras expansões (categorias, orçamentos e projeções financeiras).

## 2. Arquitetura e Estrutura de Pastas
Padrão em camadas inspirado em Domain-Driven Design (DDD), organizado sob `com.vini.controle_despesas`:
- `presentation/controller/<modulo>/`: Controllers REST granulares (uma classe por endpoint/ação) e configurações de API (`presentation/config/`).
- `application/<modulo>/`: DTOs com anotações OpenAPI (`@Schema`) e Mappers manuais com injeção de dependência (`@Component`).
- `domain/<modulo>/`:
  - `model/`: Entidades JPA mapeadas para PostgreSQL.
  - `enums/`: Enums de domínio (`DespesaTipo`, `DespesaStatus`, `DespesaPrioridade`, `ParcelamentoStatus`, `ParcelamentoJurosTipo`).
  - `service/`: Regras e cálculos matemáticos financeiros reutilizáveis.
  - `usecase/<acao>/`: Casos de uso isolados em interface (`*UseCase`) e implementação (`*UseCaseImpl`).
- `infrastructure/<modulo>/`: Repositórios de dados estendendo `JpaRepository`.
- `resources/db/migration/`: Scripts versionados de migração de banco via Flyway.

## 3. Convenções de Código e Decisões Já Tomadas
- **Stack**: Java 21, Spring Boot 4.0.3, Spring Data JPA, Hibernate, PostgreSQL, Flyway, Lombok, SpringDoc OpenAPI (Swagger).
- **Design de Casos de Uso e Controllers**: Controllers e Use Cases possuem responsabilidade única (uma classe por ação). Toda implementação de Use Case implementa uma interface correspondente.
- **Anotações de Camada**: Implementações de UseCase e Services usam `@Service`; transações de escrita usam `@Transactional`.
- **Mapeamento de Objetos**: Mapeamento manual centralizado em classes `*Mapper` anotadas com `@Component`.
- **Identificadores e Auditoria**: Chaves primárias do tipo `Long` com estratégia `IDENTITY`. Entidade `DespesaModel` implementa auditoria via `@PrePersist` e `@PreUpdate` alimentando `dataCriacao` e `dataAtualizacao` (`LocalDateTime`).
- **Precisão Monetária**: Todos os valores financeiros e taxas utilizam `BigDecimal`, com arredondamento `RoundingMode.HALF_UP` e precisão de 2 casas decimais (10 casas em cálculos intermediários de taxas).

## 4. Interfaces e Contratos entre Módulos
- **Presentation -> Domain**: Controllers invocam exclusivamente interfaces `*UseCase`, trafegando DTOs ou identificadores.
- **Domain (Despesa) -> Domain (Parcelamento)**:
  - `AdicionarDespesaUseCaseImpl` consome `CalcularValorTotalService` e `CalcularValorParcelaService` para calcular montante corrigido e valor individual das parcelas.
  - O parcelamento gerado é persistido diretamente no `ParcelamentoRepository` e atribuído como referência em `DespesaModel`.
- **Application (Mappers)**: `DespesaMapper` delega mapeamentos aninhados para `ParcelamentoMapper`.
- **Contratos de Endpoints**:
  - `POST /despesa/adicionar`: Cria despesa à vista ou parcelada (HTTP 201).
  - `GET /despesa/listar`: Retorna lista geral de despesas (HTTP 200).
  - `GET /despesa/listar/id/{id}`: Retorna despesa específica por ID (HTTP 200 / 404).
  - `GET /despesa/listar/tipo/{tipo}`: Filtra por `A_VISTA` ou `PARCELADA` (HTTP 200).
  - `GET /despesa/listar/min/{id}`: Retorna despesas com ID estritamente superior a `{id}` (HTTP 200).
  - `PATCH /despesa/atualizar/{id}`: Atualiza campos de despesa existente (HTTP 200 / 404).
  - `DELETE /despesa/apagar/{id}`: Exclui despesa por ID (HTTP 200 / 404).
  - `PATCH /parcelamento/atualizar/{id}`: Atualiza dados de parcelamento isolado (HTTP 200 / 404).

## 5. Critérios de Aceite por Funcionalidade
- **Criação de Despesa**:
  - `PARCELADA`: payload exige objeto `parcelamento` preenchido (`taxaJuros`, `quantidadeParcelas` > 0, `tipoJuros`). Deve calcular `valorTotal` (com juros) e `valorParcela`. Status inicial deve ser `EM_ANDAMENTO`, `parcelasPagas = 0`, `dataInicio` na data atual.
  - `A_VISTA`: payload não pode conter objeto `parcelamento`.
- **Cálculo de Juros**:
  - Juros Simples: $Total = Original \times (1 + (taxa / 100) \times parcelas)$.
  - Juros Compostos: $Total = Original \times (1 + (taxa / 100))^{parcelas}$.
  - Parcela: $Total / parcelas$, escala 2, `HALF_UP`.
- **Consultas**:
  - Registro não localizado por ID deve retornar HTTP 404 Not Found.
  - Consulta por ID mínimo deve retornar lista vazia (HTTP 200) caso nenhum ID seja maior.
- **Atualização e Deleção**:
  - `PATCH` atualiza apenas a entidade com o respectivo ID, preservando integridade das referências.
  - `DELETE` remove o registro indicado da base.

## 6. Fora de Escopo
- Autenticação e autorização (Spring Security, OAuth2, JWT, controle de perfis/usuários) — será implementado em rodada separada.
- Interface gráfica (frontend Web/Mobile).
- Notificações automáticas de vencimento (e-mail, webhook, SMS/push) e conciliação bancária/gateways.

## 7. Pontos Ambíguos — Decisões Tomadas
1. **Padrão de Resposta dos Controllers**: Endpoints de escrita devem retornar o DTO serializado em JSON (não `String` simples). `DELETE` deve retornar `204 No Content`.
2. **Tratamento de Exceções**: Introduzir `@RestControllerAdvice` com respostas padronizadas (RFC 7807 / Problem Details) para `400 Bad Request` e `404 Not Found`.
3. **Validação de Entrada**: Integrar `spring-boot-starter-validation` com anotações declarativas (`@NotNull`, `@NotBlank`, `@Positive`) nos DTOs.
4. **Exclusão em Cascata**: Configurar `cascade = CascadeType.ALL, orphanRemoval = true` em `DespesaModel.parcelamento` para que a deleção de despesa exclua o parcelamento associado.
5. **Flyway como Fonte Única**: Criar migration `V3` adicionando colunas de auditoria (`data_criacao`, `data_atualizacao`) em `tb_despesa` e alterar `application.properties` para `ddl-auto=validate`.
6. **Correção de Controllers**: Corrigir `ApagarDespesaController` (injetar dependência ausente), `AtualizarDespesaController` e `AtualizarParcelamentoController` (checar resultado da operação, não a dependência).
7. **Desacoplamento de ParcelamentoDTO**: Remover `@OneToOne` e referência a `DespesaModel` do DTO, mantendo-o livre de anotações JPA.
8. **Categoria**: Campo `String categoria` livre diretamente na entidade `DespesaModel` (sem tabela separada), adicionado via migration Flyway.
