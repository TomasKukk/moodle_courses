FROM openjdk:8-jdk

WORKDIR /mydir 
RUN apt-get update && apt-get install -y maven
COPY . .
RUN mvn package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "/mydir/target/moodle_courses-0.0.1-SNAPSHOT.jar"]

