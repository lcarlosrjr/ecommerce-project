# Product-Service

O Product-Service � um microservi�o respons�vel pela gest�o de produtos em um sistema de e-commerce.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Maven

## Funcionalidades

- **GET /products**: Retorna todos os produtos cadastrados.
- **GET /products/{id}**: Retorna um produto espec�fico pelo ID.
- **POST /products**: Cria um novo produto.
- **PUT /products/{id}**: Atualiza um produto existente.
- **DELETE /products/{id}**: Exclui um produto pelo ID.

## Como Executar

1. Clone o reposit�rio: `git clone https://github.com/seu-usuario/product-service.git`
2. Navegue at� o diret�rio do projeto: `cd product-service`
3. Execute a aplica��o: `mvn spring-boot:run`
4. Acesse os endpoints conforme descrito acima.

## Configura��o do Banco de Dados

O servi�o utiliza o banco de dados H2 em mem�ria por padr�o. N�o � necess�rio configurar nenhum banco de dados externo.

## Testes

O projeto inclui testes unit�rios para garantir o bom funcionamento dos servi�os.
