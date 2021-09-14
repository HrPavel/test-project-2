# Sector task backend

Service to provide ability for create personal form.

## Technologies

1. Java 11
2. Spring boot 2
3. Spring data(JPA/Hibernate)
4. RESTful Web Services via Spring Framework
5. Postgresql
6. Flyway
7. JUnit5
8.  [Swagger](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config)
9. Testcontainers

## Local running
1. Run database
```
docker-compose -f ./enviroment/docker-compose-db.yml up
```
2. Set VM option
```
-Dspring.profiles.active=dev
```
3. Run