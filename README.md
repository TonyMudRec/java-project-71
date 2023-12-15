### Hexlet tests and linter status:
[![Actions Status](https://github.com/TonyMudRec/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/TonyMudRec/java-project-71/actions)
![Build Status](https://github.com/TonyMudRec/java-project-71/actions/workflows/build-check.yml/badge.svg)
[![Maintainability](https://api.codeclimate.com/v1/badges/14be2f8258c5251e16ab/maintainability)](https://codeclimate.com/github/TonyMudRec/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/14be2f8258c5251e16ab/test_coverage)](https://codeclimate.com/github/TonyMudRec/java-project-71/test_coverage)

## Описание проекта

Вычислитель отличий – программа, определяющая разницу между двумя структурами данных. Это популярная задача, для решения которой существует множество онлайн-сервисов, например: http://www.jsondiff.com/. Подобный механизм используется при выводе тестов или при автоматическом отслеживании изменении в конфигурационных файлах.

**Возможности утилиты:**

- Поддержка разных входных форматов: yaml и json
- Возможность сравнить данные из документов разных форматов
- Генерация отчета в виде plain text, stylish и json

**Как использовать:**

1. Скачайте репозиторий.
```git clone https://github.com/TonyMudRec/java-project-71.git```

2. Зайдите в репозиторий и добавте в корень два файла, которые хотите сравнить с расширениями '.json' или '.yaml'.

3. Откройте терминал в корне репозитория и введите команду, указанную ниже. Порядок указания файлов в аргументах, влияет на результат вывода. Формат указывать не обязательно, по умолчанию 'stylish'.
```./app/build/install/app/bin/app <-f формат> <полное имя первого файла> <полное имя второго файла>``` 

