# About The Project
Twitter Clone for Twitter backend and frontend functionality using spring and react.

## Notes
* This project is a work in progress.

## Built With
* [Java 17](https://www.oracle.com/java/technologies/downloads/#java17) - The programming language used for backend
* [TypeScript](https://www.typescriptlang.org/) - The programming language used for frontend
* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [React](https://reactjs.org/) - The frontend framework used
* [PostgreSQL](https://www.postgresql.org/) - The database used

## Installation for backend
1. Clone the repo
   ```sh
   git clone https://github.com/hassanrefaat9/twitter-clone.git
    ```
2. database setup
   ```sh
   create database twitter;
   ```
3. setup gmail oauth2 to login and send emails
   ```sh
   https://developers.google.com/identity/protocols/oauth2
   ```
4. setup application.properties
   ```sh
   spring.datasource.url=jdbc:postgresql://localhost:5432/twitter
   spring.datasource.username= your username
   spring.datasource.password= your password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.properties.hibernate.format_sql=true
   server.error.include-message=always
   ```

## Installation for frontend

1. Clone the repo
   ```sh
   git clone https://github.com/hassanrefaat9/twitter-clone.git
    ```



