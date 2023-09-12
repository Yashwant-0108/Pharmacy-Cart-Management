FROM ubi8/openjdk-17

COPY target/PharmacyCartManagementService.jar app1.jar

CMD ["java", "-jar", "app1.jar"]
