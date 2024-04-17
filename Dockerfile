FROM openjdk:17

COPY build/libs/url-shortener-0.0.1-SNAPSHOT.jar url-shortener-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/url-shortener-0.0.1-SNAPSHOT.jar"]