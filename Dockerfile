FROM openjdk:19
COPY target/prometheus-springboot-monitoring-0.0.2-SNAPSHOT.jar prometheus-springboot-monitoring-0.0.2.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/prometheus-springboot-monitoring-0.0.2.jar"]