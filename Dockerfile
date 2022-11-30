FROM adoptopenjdk/maven-openjdk11
COPY ./ ./
RUN mvn clean package
ENTRYPOINT ["java","-jar","target/registration.jar"]
EXPOSE 8082