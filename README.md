# 🚗 FIPE Consulta

Aplicação Java de linha de comando que consulta a **Tabela FIPE** através de uma API REST, permitindo pesquisar veículos, modelos, anos e seus respectivos valores de avaliação.

O projeto foi desenvolvido como prática de **Java, consumo de APIs, manipulação de JSON, Streams e programação orientada a objetos**.

## ✨ Funcionalidades

* Seleção do tipo de veículo:

    * 🚗 Carros
    * 🏍️ Motos
    * 🚛 Caminhões
* Listagem de marcas disponíveis.
* Seleção de marca através do código.
* Listagem de modelos da marca selecionada.
* Busca e seleção de modelo através do código.
* Listagem dos anos disponíveis para o modelo.
* Consulta do valor FIPE para cada ano disponível.
* Exibição das informações detalhadas do veículo.

## 🛠️ Tecnologias utilizadas

* **Java**
* **Spring Boot**
* **Jackson**
* **HTTP Client**
* **Maven**
* **Streams API**
* **Records**
* **Git & GitHub**
* **FIPE API**

## 🔄 Fluxo da aplicação

```text
Tipo de veículo
       ↓
Lista de marcas
       ↓
Marca escolhida
       ↓
Lista de modelos
       ↓
Modelo escolhido
       ↓
Anos disponíveis
       ↓
Consulta da avaliação para cada ano
       ↓
Resultado
```

## 📂 Estrutura do projeto

```text
src/
└── main/
    └── java/
        └── br.com.rprojetos.FipeConsulta/
            ├── models/
            │   ├── Ano.java
            │   ├── Avaliacao.java
            │   ├── DadosModelos.java
            │   ├── Marca.java
            │   └── Modelo.java
            │
            ├── principal/
            │   └── Principal.java
            │
            └── services/
                ├── ConsumoApi.java
                ├── ConverteDados.java
                └── IConverteDados.java
```

## ▶️ Como executar

### Pré-requisitos

* Java 17 ou superior
* Maven

### Executando o projeto

Clone o repositório:

```bash
git clone https://github.com/ricksaud/FipeConsulta.git
```

Entre na pasta:

```bash
cd FipeConsulta
```

Execute a aplicação:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

## 💻 Exemplo de utilização

```text
Digite o tipo de veículo:
1 - Carros
2 - Motos
3 - Caminhões

1

Digite o código da marca:
...

Digite o código do modelo:
...

Marca: Jeep
Modelo: Renegade 1.8 4x2 Flex 16V Aut.
Ano: 2021
Combustível: Flex
Valor: R$ 75.386,00
Código Fipe: 017062-3
```

## 🎯 Objetivo do projeto

Este projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais do desenvolvimento **Java Backend**, especialmente:

* Consumo de APIs REST
* Requisições HTTP
* Desserialização de JSON
* Jackson
* Java Records
* Collections
* Streams
* Expressões lambda
* Tratamento de dados
* Organização de código em diferentes responsabilidades

## 📡 API

Os dados dos veículos são obtidos através da API pública da FIPE:

**Parallelum FIPE API**

## 👨‍💻 Autor

**Ricardo Souto**

Projeto desenvolvido como parte dos estudos de Java Backend.
