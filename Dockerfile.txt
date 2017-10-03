FROM openjdk:8

COPY target/projetospring-0.0.1-SNAPSHOT.jar projetospring.jar

ENTRYPOINT ["java", "-jar", "projetospring.jar"]