# Product-Service

O Product-Service é um microserviço responsável pela gestão de produtos em um sistema de e-commerce.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Maven

## Funcionalidades

- **GET /products**: Retorna todos os produtos cadastrados.
- **GET /products/{id}**: Retorna um produto específico pelo ID.
- **POST /products**: Cria um novo produto.
- **PUT /products/{id}**: Atualiza um produto existente.
- **DELETE /products/{id}**: Exclui um produto pelo ID.

## Como Executar

1. Clone o repositório: `git clone https://github.com/seu-usuario/product-service.git`
2. Navegue até o diretório do projeto: `cd product-service`
3. Execute a aplicação: `mvn spring-boot:run`
4. Acesse os endpoints conforme descrito acima.

## Configuração do Banco de Dados

O serviço utiliza o banco de dados H2 em memória por padrão. Não é necessário configurar nenhum banco de dados externo.

## Testes

O projeto inclui testes unitários para garantir o bom funcionamento dos serviços.
