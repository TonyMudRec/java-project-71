.DEFAULT_GOAL := build-run
	
clean:
	./gradlew clean

build:
	./gradlew clean test build

install:
	./gradlew clean install

run-dist:
	./app/build/install/app/bin/app

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

update-deps:
	./gradlew useLatestVersions


build-run: build run

.PHONY: build
