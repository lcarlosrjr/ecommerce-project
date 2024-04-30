# Auth-Service

O Auth-Service é um serviço de autenticação simples desenvolvido com Spring Boot, Spring Security e JWT (JSON Web Tokens). Este serviço permite o cadastro de usuários, login e geração de tokens JWT para autenticação em outros serviços.

## Funcionalidades

- Cadastro de usuários.
- Autenticação de usuários.
- Geração de tokens JWT.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- H2 Database (em memória)
- Maven

## Configuração

### Requisitos

- Java 8 ou superior
- Maven

### Configuração do Banco de Dados

O Auth-Service utiliza o H2 Database em memória por padrão. Não é necessário configurar nenhum banco de dados externo.

### Configuração do JWT

As configurações do JWT podem ser encontradas no arquivo `application.properties`. Você pode alterar o segredo e o tempo de expiração do token conforme necessário.

```properties
# Configurações do JWT
jwt.secret=secreto
jwt.expiration.ms=86400000
```
## Build e Execução
### Clone o repositório:
```properties
git clone https://github.com/seu-usuario/auth-service.git
```

### Navegue até o diretório do projeto:
```properties
cd auth-service
```

### Execute o projeto usando Maven:
```properties
mvn spring-boot:run
``` 
O serviço estará disponível em http://localhost:8080.
<br>
### Endpoints
#### Cadastro de Usuários
**URL**: /auth/signup
**Método**: POST
**Corpo da Requisição**: JSON contendo os campos username e password.

##### Exemplo de requisição:

``` properties
{
  "username": "usuario",
  "password": "senha"
}
```
#### Login
**URL**: /auth/login
**Método**: POST
**Parâmetros da Requisição**: username e password.

Exemplo de requisição:

`/auth/login?username=usuario&password=senha`
<br>
#### Exemplo de Uso do Token JWT
O token JWT gerado após o login deve ser incluído no cabeçalho Authorization nas requisições subsequentes para autenticação.

`Authorization: Bearer <token_jwt>`