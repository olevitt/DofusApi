FROM maven:3.6.3-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM maven:3.6.3-jdk-11
COPY --from=build /home/app/target/dofusapi-0.0.1-SNAPSHOT.jar /usr/local/lib/dofusapi.jar
CMD ["java","-jar","/usr/local/lib/dofusapi.jar"]

#RUN apt-get install unzip
#RUN curl -o ./dofusapi.zip https://github.com/Sifui/DofusApi/suites/2247870011/artifacts/46722565
#RUN unzip /app.zip
#CMD ["java", "-jar","/app.jar"]