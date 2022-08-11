FROM openjdk:17-bullseye
COPY target/Login-0.0.1-SNAPSHOT.jar /usr/login.jar
COPY scripts/ssl.sh /usr/ssl.sh
RUN sh /usr/ssl.sh
CMD ["rm", "/usr/ssl.sh"]
WORKDIR /usr/
CMD ["java", "-jar", "login.jar"]