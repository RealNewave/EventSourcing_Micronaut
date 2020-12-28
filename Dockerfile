FROM openjdk:14-jdk-alpine

COPY target/*.jar eventsourcing.jar
ENTRYPOINT ["java","-jar","/eventsourcing.jar"]
