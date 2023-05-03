test-run:
	./build/install/app/bin/app src/test/resources/files/file1.json src/test/resources/files/file2.json

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

build:
	./gradlew clean build

report:
	./gradlew jacocoTestReport

.PHONY: build
