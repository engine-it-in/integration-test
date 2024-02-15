# integration-tests

## Что это?

* [Описание](https://habr.com/ru/companies/alfastrah/articles/792598/)

## Какая от этого польза?
* На тестовой среде -> интеграционные тесты, которые проверяют окружение продукта после внесенных изменений;
* На продуктивной среде -> тесты доступности, которые проверяют продуктивный ландшафт;
* Проект содержит [папку](/src/test/resources/json) в которой находятся запросы/ответы ко всем сервисам, покрытым
  интеграционными тестами. Так у разработчика есть дополнительный источник правды, когда нужно: узнать контракт сервиса,
  протестировать сервис и т.д., но при этом это приносит дополнительные ограничения - в случае проблем с данными в
  системе, к которой идет запрос, данные нужно поменять и в этом проекте;

## Где это используется?
* Тестовая среда;
* Продуктивная среда;
* Локальная разработка - есть возможность проверить состояние тестовой среды/продуктивной среды имея у себя этот проект;

## Где посмотреть результаты работы этого проекта
* Allure отчеты -> **[TBD] - Нужно добавить ресурс на котором отчет будет публиковаться**;
* У нас сделано на технологии gitlab pages;

## Как используется этот проект?

* Локальная проверка работы сервиса;
* В pipeline для тестовой среды;
* В pipeline для прод среды;
* Запуск проекта для dev и мастер
  среды -> **[TBD] Нужно добавить schedule для ресурса, где Вы будете исполнять отчет**;

## Безопасность

* Первоначальные данные для доступа в vault (хранилище секретов) доступны для приложения через CI variables проекта;
* Первоначальные данные для доступа в vault доступны в контекст приложения
  через [EnvironmentProperty](src/main/java/ru/nikitinia/integrationtests/logicwrapper/PropertyWrapper.java);
* В проекте, для доступа к сервисам, которым требуется аутентификация,  реализован механизм запроса секретных данных в vault,
  с последующим запросом пароля в провайдер секретных данных::
    * Работа с [АПИ vault](src/main/java/ru/nikitinia/integrationtests/service/providesecrets)
        * Для каждого сервиса имплементация сервисов vault
          реализуется [по-своему](src/main/java/ru/nikitinia/integrationtests/service/providesecrets/someservisewhiccneddprovide)
          из-за разного представления наименования паролей;
    * Работа с [провайдером паролей](src/main/java/ru/nikitinia/integrationtests/service/authorization/Authorize.java);
    * Для работы по получения токена в конкретном тестовом классе вызывается провайдер паролей для получения токена и
      последующей [обработки](src/test/java/ru/nikitinia/integrationtests/someservisewithauthorization/settings/SomeServiceCase/SomeServiceCase.java);


## Алгоритм запуска проекта

* В проекте для работы с конфигурацией прода и конфигурацией теста используются разные файлы **.properties**,
  расположенные [тут](/src/main/resources/env)
* Оркестрирует запускаемой конфигурацией [maven](pom.xml):
    * [Maven](pom.xml) блок build->filters - откуда брать файл с переменными, связанные с конкретным запускаемым
      профилем maven;
    * [Maven](pom.xml) блок build->resources - откуда брать файл, который в коде трансформируется в
      заполненный [объект](src/main/java/ru/alfastrah/odm/integrationtests/property/PropertyWrapper.java);
    * [Maven](pom.xml) блок profiles -> профили мавена. При запуске тестов необходимо указать, запуск с каким профилем
      происходит. В зависимости от указанного значения в build->resources будет использован один из файлов;
* Локальный запуск проекта c профилем:
    * `mvn package -P [наименовние профиля]` - указываем профиль, с которым собираем приложение. Профиль необходимо переупыковывать после изменения конфигурационных файлов;
    * `run all test` (idea) - прогоняем тесты;
* Команды запуска мавена с профилем, реализуемые в [pipeline]([TBD]):
    * `mvn compile -P [наименование профиля] verify -D[системная переменная проекта]=${[переменная gitlab CI]}`;
    * [системная переменная проекта] -> переменные, добавляемые при старте приложения из [внешнего контекста](src/main/resources/env.properties)
    * [переменная gitlab CI] -> переменные, соответствующие системным переменные проекта, скрытые в gitlab CI;

      
## Структура проекта

* [Работа со свойствами и утилиты для удобной работы с файлами, используемыми в тестах](src/main/java/ru/nikitinia/integrationtests);
* [Конфигурации, используемые maven](src/main/resources);
* Тестовый сьюты на сервисы: название папки -> тестируемый сервис;
* [Json файлы request/response](src/test/resources/json);
* [Настройки allure отчетов](src/test/resources/allure.properties);

### Пояснения к структуре

* Проект содержит [папку](/src/test/resources/json) в которой находятся запросы/ответы ко всем сервисам, покрытым
    интеграционными тестами. 
* Так у разработчика есть дополнительный источник правды, когда нужно: 
  * Узнать контракт сервиса; 
  * Протестировать сервис; 
  * и т.д., 
* При этом есть ограничение -> в случае проблем с данными в системе, к которой идет запрос, данные нужно актуализировать;

## Как это дорабатывать?

* Скачивать проект и наслаждаться, не забывая проверять сделанное как в тестовом, так и в прод окружении;

## Что нужно адаптировать?
* В проекте расставлены пасхалии -> **[TBD]**
* Эти пасхалии наводят Вас на мысль о том, что нужно определить для адаптации проекта у себя;

## С кем поговорить, если есть вопросы/дополнения?

| №   | Если вопрос про                     | Контакт                               |
|-----|-------------------------------------|---------------------------------------|
| 1   | Код, настройки                      | in86@inbox.ru, nikitinia@alfastrah.ru |
