FROM eclipse-temurin:21-jre-jammy

COPY target/*.jar /usr/app/

WORKDIR /usr/app

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "01-Book-Store-App-1-0.0.1-SNAPSHOT.jar"]