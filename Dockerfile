#Build Stage
FROM maven:3.6-openjdk-17 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM openjdk:17.0.1-slim
COPY ./cacerts /etc/ssl/certs/java/
COPY --from=build /usr/src/app/target/wily-start-project-1.0.0.jar /usr/app/wily-start-project-1.0.0.jar
ENTRYPOINT ["java","-Duser.timezone=GMT","-jar","/usr/app/wily-start-project-1.0.0.jar"]
