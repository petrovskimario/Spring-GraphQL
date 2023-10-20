# Spring GraphQL

This repository is a trivial sample for a GraphQL API using Spring Boot.
It contains the CRUD operations for Book and exception handler.
From here on you can start building your service.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Java JDK 17
* PostgreSQL
* Docker

### Installing

* Clone repo
* Import the project in any IDE

### Build and Start the project

* Build the project

Before starting the project, you need to create a database in PostgreSQL.
Here is a docker command to create a PostgreSQL database :
docker run --name postgres-graphql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=graphql -p 5432:5432 -d postgres:latest

After that modify the application.yml file with your database credentials.

If you want to start it as a JAR, build the project using the following command : 
mvn clean package

Otherwise import it into any IDE and start the project.

* Open the browser and go to http://localhost:8080/graphiql

### Sample Queries

```

Get book by id : 

query{
  getById(id:2) {
    id
    name
  }
}

Get all books : 

query{
  getAllBooks{
    id
    name
  }
}

```

### Sample Mutations

```

Create Book : 

mutation{
  createBook(name:"SomeName") {
    id
    name
  }
}

Create Book with new Authors : 

mutation {
  createBook(name: "Your Book Name", authorNames: ["Author 1", "Author 2"]) {
    id
    name
    # Add any other fields you want to retrieve from the created book
  }
}


Update Book : 

mutation{
  updateBook(id:52,name:"Updated Name") {
    id
    name
  }
}

Delete Book : 

mutation{
  deleteBook(id:52)
}

```


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/) - Dependency Management
* [GraphQL](https://graphql.org/)