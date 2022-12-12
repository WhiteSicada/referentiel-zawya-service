FROM openjdk:8
EXPOSE 8081
ADD build/libs/zawiya-referentiel-service.jar zawiya-referentiel-service.jar
ENTRYPOINT ["java","-jar","zawiya-referentiel-service.jar"]