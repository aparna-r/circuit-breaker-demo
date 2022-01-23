FROM openjdk:8u131-jre-alpine

RUN mkdir -p /etc/app/
COPY target/payment-service.jar /etc/app/

EXPOSE 20001

CMD ["java","-Dserver.port=20001", "-jar", "/etc/app/payment-service.jar"]
