# Spring Boot Domain Event

This simple application makes REST requests to this
[URL](https://quoters.apps.pcfone.io/api/random) 
to create random JSON objects. 
It publishes a domain event for each JSON object, 
handles the event by itself and saves it to the H2 database.
To see the saved events, open H2 console in the following URL
```url
http://localhost:8080/h2-console/
```
and enter `jdbc:h2:mem:testdb` in the `JDBC URL` entry. 
The events are in the `QUOTE_EVENT` table.