# Auth-Service

O Auth-Service � um servi�o de autentica��o simples desenvolvido com Spring Boot, Spring Security e JWT (JSON Web Tokens). Este servi�o permite o cadastro de usu�rios, login e gera��o de tokens JWT para autentica��o em outros servi�os.

## Funcionalidades

- Cadastro de usu�rios.
- Autentica��o de usu�rios.
- Gera��o de tokens JWT.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- H2 Database (em mem�ria)
- Maven

## Configura��o

### Requisitos

- Java 8 ou superior
- Maven

### Configura��o do Banco de Dados

O Auth-Service utiliza o H2 Database em mem�ria por padr�o. N�o � necess�rio configurar nenhum banco de dados externo.

### Configura��o do JWT

As configura��es do JWT podem ser encontradas no arquivo `application.properties`. Voc� pode alterar o segredo e o tempo de expira��o do token conforme necess�rio.

```properties
# Configura��es do JWT
jwt.secret=secreto
jwt.expiration.ms=86400000
```
## Build e Execu��o
### Clone o reposit�rio:
```properties
git clone https://github.com/seu-usuario/auth-service.git
```

### Navegue at� o diret�rio do projeto:
```properties
cd auth-service
```

### Execute o projeto usando Maven:
```properties
mvn spring-boot:run
``` 
O servi�o estar� dispon�vel em http://localhost:8080.
<br>
### Endpoints
#### Cadastro de Usu�rios
**URL**: /auth/signup
**M�todo**: POST
**Corpo da Requisi��o**: JSON contendo os campos username e password.

##### Exemplo de requisi��o:

``` properties
{
  "username": "usuario",
  "password": "senha"
}
```
#### Login
**URL**: /auth/login
**M�todo**: POST
**Par�metros da Requisi��o**: username e password.

Exemplo de requisi��o:

`/auth/login?username=usuario&password=senha`
<br>
#### Exemplo de Uso do Token JWT
O token JWT gerado ap�s o login deve ser inclu�do no cabe�alho Authorization nas requisi��es subsequentes para autentica��o.

`Authorization: Bearer <token_jwt>`