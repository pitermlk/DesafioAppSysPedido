# Aplicação de Gerenciamento de Pedidos com Spring Boot

## Visão Geral
Esta aplicação Spring Boot foi desenvolvida para gerenciar pedidos, incluindo funcionalidades para o manejo de clientes, produtos, pedidos e itens de pedidos. Utiliza MySQL como banco de dados e demonstra o desenvolvimento de uma API RESTful com Spring Boot.

## Requisitos
- **Java JDK 11** ou superior
- **Maven 3.6** ou superior
- **Docker** e **Docker Compose** para o MySQL
- **IntelliJ IDEA**
- **Postman** para testar a API

## Configuração Local

### Configuração do Banco de Dados
1. **Iniciar o Banco de Dados MySQL**
    - Abra um terminal e navegue até o diretório onde o `docker-compose.yml` está localizado.
    - Execute o comando:
      ```bash
      docker-compose up -d
      ```

### Importando o Projeto no IntelliJ IDEA
1. **Abra o IntelliJ IDEA**.
2. **Importe o projeto**:
    - Escolha `File > Open` e selecione o diretório raiz do projeto.
    - Confirme a importação do projeto como um projeto Maven para que as dependências sejam resolvidas automaticamente.

### Configurações do Aplicativo
- As configurações padrão do banco de dados podem ser encontradas em `src/main/resources/application.properties`.
- Assegure-se de que o IntelliJ esteja configurado para usar o JDK 11 ou superior em `File > Project Structure > Project`.

### Executando a Aplicação
1. **Na barra de ferramentas do IntelliJ**, localize e clique no botão de `Run` ('Play') para iniciar a aplicação.
2. **Verifique se a aplicação está rodando** acessando `http://localhost:8080`.

## Testando a API com Postman
1. **Abra o Postman**.
2. **Configure as requisições** para os endpoints descritos abaixo utilizando o método apropriado (GET, POST):
    - **Clientes**:
        - `GET /clientes`: Lista todos os clientes.
        - `POST /clientes`: Adiciona um novo cliente.
    - **Produtos**:
        - `GET /produtos`: Lista todos os produtos.
        - `POST /produtos`: Adiciona um novo produto.
    - **Pedidos**:
        - `GET /pedidos`: Lista todos os pedidos.
        - `POST /pedidos`: Cria um novo pedido.
    - **Itens de Pedido**:
        - `GET /itens-pedido`: Lista todos os itens de um pedido.
        - `POST /itens-pedido`: Adiciona itens a um pedido específico.

### Utilizando Swagger UI
- Acesse `http://localhost:8080/swagger-ui.html` para visualizar e interagir com a documentação da API via Swagger UI.

### Parando a Aplicação
- Para interromper a aplicação no IntelliJ, utilize o botão de `Stop` ('Quadrado') na barra de ferramentas.
- Para interromper o MySQL, execute:
  ```bash
  docker-compose down
  ```

## Suporte
Para dúvidas ou suporte, por favor, consulte a documentação do projeto ou abra uma issue no repositório do GitHub.
