FROM openjdk:17

COPY target/01-Book-Store-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "01-Book-Store-0.0.1-SNAPSHOT.jar"]