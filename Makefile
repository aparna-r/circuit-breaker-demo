run: build \
	 run-docker \

build:
	@echo "building project..."
	mvn clean install

run-docker:
	@echo "running api..."
	docker-compose up -d
