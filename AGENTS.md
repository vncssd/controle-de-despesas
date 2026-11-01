# Diretrizes para Agentes de IA — Controle de Despesas

> **REGRA GERAL E MANDATÓRIA:**
> Todo agente ou subagente (incluindo `escritor`, `testador`, `depurador`, `revisor`, `refatorador`, etc.) **DEVE** ler integralmente o arquivo `SPEC.md` localizado na raiz do projeto **ANTES** de executar qualquer tarefa, planejar mudanças ou escrever código.

---

## 1. Fluxo Obrigatório de Execução

Antes de iniciar qualquer ação no repositório:
1. **Leitura Prévia do `SPEC.md`**:
   - Utilize a ferramenta de leitura de arquivos para consultar o `SPEC.md`.
   - Nenhuma suposição sobre arquitetura, contratos REST, cálculos ou regras de negócio deve ser feita sem verificar a especificação.
2. **Checagem de Escopo e Pontos Ambíguos**:
   - Verifique a seção **6. Fora de escopo** do `SPEC.md`. Não implemente nada listado ali sem autorização explícita.
   - Verifique a seção **7. Pontos ambíguos**. Se a tarefa envolver um ponto sem decisão registrada, **não invente a resposta**: pergunte ao usuário antes de implementar.
3. **Execução Alinhada**:
   - Siga rigorosamente as convenções de código, arquitetura em camadas e critérios de aceite da especificação.

---

## 2. Princípios de Arquitetura e Código

- **Arquitetura em Camadas (DDD)**:
  - `presentation`: Controllers REST granulares (uma classe/endpoint por operação).
  - `application`: DTOs e Mappers manuais com `@Component`.
  - `domain`: Modelos JPA, Enums, Services matemáticos/negócio e Use Cases (interface + implementação).
  - `infrastructure`: Repositórios estendendo `JpaRepository`.
- **Precisão Financeira**:
  - Valores monetários e taxas devem usar estritamente `BigDecimal` com arredondamento `RoundingMode.HALF_UP` e 2 casas decimais (10 casas intermediárias em taxas de juros).
- **Integridade da Base**:
  - Mudanças de esquema devem passar exclusivamente por migrations versionadas do Flyway em `src/main/resources/db/migration/`.

---

## 3. Checklist de Validação do Agente

Antes de dar uma tarefa por concluída, certifique-se de que:
- [ ] O `SPEC.md` foi lido e respeitado em todos os pontos.
- [ ] As convenções de nomenclatura e granularidade de classes foram seguidas.
- [ ] Nenhum código quebra os contratos de DTOs ou entidades existentes sem migração planejada.
- [ ] Testes existentes ou novos cobrem os critérios de aceite relevantes.
