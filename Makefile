build:
	make -C app build

run-dist:
	make -C app test-run

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

.PHONY: build
