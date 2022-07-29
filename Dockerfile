FROM openjdk
WORKDIR /app
COPY target/tomath-api-1.0.jar /tomath-api.jar
ENTRYPOINT ["java","-jar","/tomath-api.jar"]