# Graphql Example

Project example to show how to make and use a grapqhl api

The project creates a database where one person can create one ore more questions

## Installing

Prerequisites
- Java >= 8
- Maven

Clone the repo

Generate the jar file with maven
```
mvn clean install
```

Run the application
```
java -jar target/graphql-0.0.1.jar
```

## How to use

The end point for the grahpql querys is
```
http://localhost:8080/graphql
```

Or can use Grahpiql to write querys
```
http://localhost:8080/graphiql
```

### Examples

Find all persons 

```
{
	findAllPersons{
    lastName
    firstName
    questions{
      id
      question
    }
  }
}
```

Create new Person
```
mutation{
  createPerson(firstName: "Mauricio", lastName: "Medina"){
    	id
    	firstName
  }
}
```
