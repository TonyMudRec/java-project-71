test-run:	
	./build/install/app/bin/app src/test/resources/files/file3.yaml src/test/resources/files/file4.yaml
	./build/install/app/bin/app src/test/resources/files/file3.json src/test/resources/files/file4.json

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

build:
	./gradlew clean build

report:
	./gradlew jacocoTestReport

.PHONY: build
