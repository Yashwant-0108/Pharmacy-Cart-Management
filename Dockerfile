FROM openjdk:17-jdk

COPY target/PharmacyCartManagementService.jar app1.jar

CMD ["java", "-jar", "app1.jar"]