# User Mongo API

Spring Boot REST API using NoSql database.

## Stack

- Java 13
- Gradle 6.0.1
---

#### Dependences:

- Lombok
- MongoDb
- Spring Web
- Spring Boot DevTools
- Swagger 

---

### Build

Execute the project

to execute locally:

To execute the project in a local environment you need to execute the docker-compose first:

```sh
docker-compose -f devops/docker/docker-compose.yml up
```
---

#### Eclipse import project: 

`File > Import > Gradle > Existing Gradle Projects`

`Right click on the project > Gradle > Refresh Gradle Project`

## Build

On console:

```sh
./gradlew build clean(Unix)
```

```sh
./gradlew.bat build clean(Windows)
```
