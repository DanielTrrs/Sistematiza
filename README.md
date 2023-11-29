# Sistematiza

Pré-requisitos

Linguagem Java versão 17

Banco de dados PostgreSQL

Instalação

Clonagem do projeto

Importação para o Eclipse

Conversão do projeto para Maven

Inicialização

Acesso
Inicie um gestor de API; sugiro o Postman.



Utilização
Para incluir um entregador

- URI: http://localhost:8080/entregadores

- Método: POST

- Formulário JSON: nome,cpf e capacidade
Para listar todos os entregadores

- URI: http://localhost:8080/entregadores

- Método: GET
Para mostrar apenas um entregador

- URI: http://localhost:8080/entregadores/{id}

- Método: GET
Para excluir um entregador

- URI: http://localhost:8080/entregadores/{id}

- Método: DELETE
Para alterar um entregador

- URI: http://localhost:8080/entregadores/{id}

- Método: PUT

- Formulário JSON: nome,cpf e capacidade


Resolução do Problema

O código apresentado implementa um controlador (controller) em uma aplicação Spring Boot para gerenciar operações relacionadas a entregadores. Ele resolve o problema de criar, listar, detalhar, atualizar e excluir informações sobre entregadores em um sistema.
