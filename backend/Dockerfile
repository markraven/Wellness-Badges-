FROM maven:3-openjdk-11 as build

WORKDIR /tmp
COPY pom.xml .
ADD src src
RUN mvn package spring-boot:repackage

FROM openjdk:11-jre

EXPOSE 8080
WORKDIR /usr/src/myapp
COPY --from=build /tmp/target/backend.jar .
CMD java -jar backend.jar
