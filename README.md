# java-spring-starter

A starter project utilizing Java + Spring Boot. Setup with Hibernate/JPA for a persistence layer.

### Setup w/ IntelliJ

1. Open application folder up in IntelliJ and automatically setup JDK 1.8 and have it auto-import all mvn dependencies and plugins.
2. Go to `Run -> Edit Configurations` and select `Application` from the Spring Boot option.
3. In the `Before Launch` section, add a maven goal. In the text area type `clean compile` and click `Add`.
4. Move the new maven goal above the `Build` goal.
5. Start the project by selecting `Application` from the run dropdown and click `Run Application` (or `Debug`)

### Docker setup

To build the docker file: `mvn install dockerfile:build`

To run the docker container: `docker run -p 8080:8080 -t <username>/<projectname>`
