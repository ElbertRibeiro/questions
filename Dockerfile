FROM maven:3-adoptopenjdk-8
WORKDIR /usr/app
COPY . .
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]