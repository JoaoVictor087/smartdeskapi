# SmartDesk API - Global Solution 2025

API RESTful desenvolvida para o gerenciamento de espaços de trabalho híbridos (Coworking/Smart Offices). O sistema permite o cadastro de usuários, gestão de mesas com sensores IoT integrados e realização de reservas, promovendo a otimização do uso do espaço físico.

Projeto desenvolvido como parte da avaliação **Global Solution**.

## Tecnologias Utilizadas

* **Java 25** 
* **Spring Boot 3.5.7**
* **Spring Security + JWT** (Autenticação e Autorização)
* **Spring Data JPA** (Persistência de dados)
* **Oracle Database** (Banco de dados relacional)
* **Lombok** (Redução de boilerplate code)
* **Swagger / OpenAPI** (Documentação da API)
* **Docker** (Containerização)

---

## Configuração Obrigatória (.env)

Para que a aplicação funcione corretamente e consiga conectar ao banco de dados Oracle, é **obrigatório** criar um arquivo chamado `.env` na **raiz do projeto**.

O professor/avaliador deve mover manualmente o arquivo contendo as credenciais para a raiz do programa.

```properties
# Configurações do Banco de Dados Oracle
DB_URL=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
DB_USERNAME=USUARIO_DB
DB_PASSWORD=SENHA_DB

# Segredo para assinatura do Token JWT
JWT_SECRET=SENHAJWT

```
---

Video Demonstração do projeto

[Vídeo de Demonstração da Sprint 2](https://www.youtube.com/watch?v=cfaMYLa74yI)
