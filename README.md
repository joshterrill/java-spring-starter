# java-spring-starter

A starter project utilizing Java + Spring Boot. Set up with Hibernate/JPA for a persistence layer.

### Server Setup w/ IntelliJ

1. Open application folder up in IntelliJ and automatically setup JDK 1.8 and have it auto-import all mvn dependencies and plugins.
2. Go to `Run -> Edit Configurations` and select `Application` from the Spring Boot option.
3. In the `Before Launch` section, add a maven goal. In the text area type `clean compile` and click `Add`.
4. Move the new maven goal above the `Build` goal.
5. Start the project by selecting `Application` from the run dropdown and click `Run Application` (or `Debug`)

### Database Setup (Hibernate)

1. Find and replace `<databaseip>, <databaseport>, <databasename>, <databaseuser>, <databasepassword>` with your details.
2. Run `mvn clean compile` to generate your persistent entity classes which get put in `target/generated-sources/`
3. (Optional) If you do not want to use the hibernate templates provided in `resources/hibernate/templates`, you can remove the `<templatePath />` property from the `hbm2java` goal in the `pom.xml`.

### Directory structure

* `controllers/` - where controllers are defined, these would be REST endpoints that Spring Boot would autodetect and wire into your app.

* `models/` - where any custom models would go, but also the package where generated hibernate entities are stored as well.

* `repositories/` - if you would like to take advantage of jpa and use your generated entity classes as an ORM, you can create repositories for them here.

* `services/` - where service and service impl classes are created, this is where business logic is performed. Often times also where repositories are auto-wired to be used within controllers.

### Docker setup

To build the docker file: `mvn install dockerfile:build`

To run the docker container: `docker run -p 8080:8080 -t <username>/<projectname>`
