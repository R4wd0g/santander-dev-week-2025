# Santander Dev Week 2023
Java RESTful API criada para a Santander Dev Week.

## Diagrama de Classes

```mermaid
classDiagram
    class User {
      -string name
      -Account account
      -Feature[] features
      -Card card
      -News[] news
    }

    class Account {
      -string number
      -string agency
      -float balance
      -float limit
    }

    class Card {
      -string number
      -float limit
    }

    class Feature {
      -string icon
      -string description
    }

    class News {
      -string icon
      -string description
    }

    User "1" *-- "1" Account : account
    User "1" *-- "N" Card : card
    User "1" *-- "1" Feature : features
    User "1" *-- "N" News : news

```