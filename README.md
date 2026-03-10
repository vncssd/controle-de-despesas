# Controle de Despesas — API
API REST para gerenciamento de despesas pessoais desenvolvida com Java e Spring Boot.
---
## 🚀 Tecnologias
- **Java 21**
- **Spring Boot 4.x**
- **Spring Data JPA / Hibernate**
- **PostgreSQL**
- **Flyway**
- **Lombok**
- **Docker**
- **SpringDoc OpenAPI (Swagger)**
---
## 🏛️ Arquitetura
O projeto adota **Domain Driven Design (DDD)** com arquitetura em camadas, onde cada domínio é independente com suas próprias entidades, casos de uso e regras de negócio isoladas.
```
src/
└── main/
    └── java/com/controle_despesas/
        ├── presentation/          # Controllers REST
        ├── application/           # DTOs e Mappers
        └── domain/
            ├── despesa/
            │   ├── model/
            │   ├── enums/
            │   ├── repository/
            │   └── usecase/
            ├── parcelamento/
            │   ├── model/
            │   ├── enums/
            │   ├── repository/
            │   ├── service/       # Services de Cálculo de Juros, Valor Total e Valor de Parcela
            │   └── usecase/
            └── ...
```
---
## 📦 Módulos
| Módulo | Status |
|---|---|
| Despesas | ✅ Concluído |
| Parcelamento e Juros | ✅ Concluído |
| Categorias | 🚧 Em andamento |
| Plano de Gastos por Período | 🚧 Em andamento |
| Estimativas de Gastos | 🚧 Em andamento |
| Planejamento de Investimentos | 🚧 Em andamento |
---
## ▶️ Como Executar
### Pré-requisitos
- Java 21+
- Maven
- Docker e Docker Compose
### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/controle-despesas.git
cd controle-despesas
```
### 2. Configure as variáveis de ambiente
Crie um arquivo `.env` na raiz do projeto com base no `.env.example`:
```env
DB_URL=url_do_banco
DB_NAME=controle-despesas
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
```
### 3. Suba o banco de dados com Docker
```bash
docker compose up -d
```
O container irá criar o banco `controle-despesas` automaticamente com as credenciais definidas no `.env`. Para verificar se subiu corretamente:
```bash
docker ps
```
### 4. Configure o application.properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/controle-despesas
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=validate
```
### 5. Execute a aplicação
```bash
./mvnw spring-boot:run
```
A API estará disponível em `http://localhost:8080`.
As tabelas serão criadas automaticamente pelo Flyway na primeira execução.

### Parar o banco
```bash
docker compose down
```
> Os dados ficam preservados no volume `postgres_data`. Para remover os dados junto com o container, use `docker compose down -v`.

---
## 📄 Documentação
A documentação interativa da API é gerada automaticamente pelo **SpringDoc OpenAPI** e pode ser acessada com a aplicação rodando:

| Interface | URL |
|---|---|
| Swagger UI | http://localhost:8080/swagger-ui.html |
| OpenAPI JSON | http://localhost:8080/v3/api-docs |

O Swagger UI permite visualizar todos os endpoints disponíveis, ver os modelos de requisição e resposta, e testar as chamadas diretamente pelo navegador sem precisar de nenhuma ferramenta externa.

---
## 🗂️ Endpoints — Despesas
| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/despesa/adicionar` | Adiciona uma nova despesa |
| `GET` | `/despesa/listar` | Lista todas as despesas |
| `GET` | `/despesa/listar/id/{id}` | Busca uma despesa por id |
| `GET` | `/despesa/listar/tipo/{tipo}` | Lista despesas por tipo (A_VISTA ou PARCELADA) |
| `PATCH` | `/despesa/atualizar/{id}` | Atualiza campos de uma despesa |
| `DELETE` | `/despesa/apagar/{id}` | Remove uma despesa |
---
## 📌 Roadmap
- [x] CRUD de despesas
- [x] Integração com PostgreSQL
- [x] Cálculo de juros simples e compostos em parcelamentos
- [x] Gestão de categorias e prioridades
- [x] Dockerização do banco de dados
- [x] Documentação com Swagger
- [ ] Planos de gastos por semana, feriado e período customizado
- [ ] Estimativas baseadas em histórico por categoria
- [ ] Planos de investimento personalizados
- [ ] Autenticação com Spring Security + JWT
---
## 👤 Autor
Desenvolvido por **Vinicius Silva — https://www.linkedin.com/in/vncssd/**
