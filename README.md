
# Controle de Despesas — API

API REST para gerenciamento de despesas pessoais desenvolvida com Java e Spring Boot, seguindo os princípios de Domain Driven Design. O sistema oferece controle de gastos fixos e variáveis, cálculo de parcelamentos com juros, planos de gastos por período e planejamento de investimentos.

---

## 🚀 Tecnologias

- **Java 21**
- **Spring Boot 4.x**
- **Spring Data JPA / Hibernate**
- **PostgreSQL**
- **Flyway**
- **Lombok** 

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
- PostgreSQL instalado e rodando localmente

### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/controle-despesas.git
cd controle-despesas
```

### 2. Crie o banco de dados
Com o PostgreSQL rodando, crie o banco pelo terminal ou pelo seu cliente de preferência (DBeaver, pgAdmin etc.):
```sql
CREATE DATABASE controle_despesas;
```

### 3. Configure o application.properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/controle_despesas
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=validate
```

### 4. Execute a aplicação
```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.
As tabelas serão criadas automaticamente pelo Flyway na primeira execução.


---

## 🗂️ Endpoints — Despesas

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/despesa/adicionar` | Adiciona uma nova despesa |
| `GET` | `/despesa/listar` | Lista todas as despesas |
| `GET` | `/despesa/listar/id/{id}` | Busca uma despesa por id |
| `GET` | `/despesa/listar/tipo/{tipo}` | Lista despesas por tipo(A VISTA ou PARCELADA) |
| `PATCH` | `/despesa/atualizar/{id}` | Atualiza campos de uma despesa |
| `DELETE` | `/despesa/apagar/{id}` | Remove uma despesa |

---


## 📌 Roadmap

- [x] CRUD de despesas
- [x] Integração com PostgreSQL
- [x] Cálculo de juros simples e compostos em parcelamentos
- [x] Gestão de categorias e prioridades
- [ ] Planos de gastos por semana, feriado e período customizado
- [ ] Estimativas baseadas em histórico por categoria
- [ ] Planos de investimento personalizados
- [ ] Autenticação com Spring Security + JWT

---

## 👤 Autor

Desenvolvido por **Vinicius Silva - https://www.linkedin.com/in/vncssd/**
