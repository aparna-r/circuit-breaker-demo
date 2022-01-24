# Prerequisite software
- [Java 8](https://www.oracle.com/java/technologies/downloads/) 
- [Maven 3](https://maven.apache.org/download.cgi)
- [Make 3](https://www.gnu.org/software/make/)
- [docker](https://docs.docker.com/get-docker/)

# Run the project
- cd to project directory
- `make run`
- Services will be available at following urls
  - order service: http://localhost:20000
  - payment service: http://localhost:20001
  - prometheus: http://localhost:9090
  - grafana: http://localhost:3000
  - configure grafana with prometheus using spring actuator as explained [here](https://medium.com/javarevisited/springboot-app-monitoring-with-grafana-prometheus-7c723f0dec15)

# Project Structure
- order-service: maven module implementing an order service which connects to payment service for order execution
- payment-service: maven module implementing a payment service which executes a payment
- Makefile: builds services docker images and starts all docker containers
- demo.sh: calls order service which different options. see file for details.
- prometheus.yml: used as prometheus config for prometheus docker container
- grafana_dashboard.yml: grafana dashboard provided by [resilience4j](https://github.com/resilience4j/resilience4j/blob/master/grafana_dashboard.json)

# Test CircuitBreaker
- demo.sh: accepts 1 optional parameter. Makes call to order service with one of the types
   - fail: makes call to order service which makes fail call to payment service
   - slow: makes call to order service which makes a slow call to payment service
   - default: makes successful call to order service including upstream service

