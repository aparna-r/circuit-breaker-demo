FROM openjdk:8u131-jre-alpine

RUN mkdir -p /etc/app/
COPY target/order-service.jar /etc/app/

EXPOSE 20000

CMD ["java","-Dserver.port=20000", "-jar", "/etc/app/order-service.jar"]
