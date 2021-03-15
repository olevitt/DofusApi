FROM maven:3.6.3-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre
COPY --from=build /home/app/target/dofusapi-0.0.1-SNAPSHOT.jar /usr/local/lib/dofusapi.jar
CMD ["java","-jar","/usr/local/lib/dofusapi.jar"]