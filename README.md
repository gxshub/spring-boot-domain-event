# Spring Boot - Domain Events

This simple application makes REST requests to this
[URL](https://quoters.apps.pcfone.io/api/random) 
to create random JSON objects. 
It publishes a domain event for each JSON object, 
handles the event by itself and saves the event to the H2 database.

To view the saved events, we use the H2 console. Add the following two lines to `src/main/resources/application.properties`:
```
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
```
Open the following URL in your browser
```url
http://localhost:8080/h2-console/
```
and change the value in the `JDBC URL` entry to `jdbc:h2:mem:testdb`.
The events are in the `QUOTE_EVENT` table.
