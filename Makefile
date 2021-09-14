build:
	cd sectors-task-be  && ./gradlew build
	cd ..
	docker-compose up -d
