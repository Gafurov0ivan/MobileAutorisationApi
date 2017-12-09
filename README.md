[![Build Status](https://travis-ci.org/Gafurov0ivan/MobileAutorisationApi.svg?branch=master)](https://travis-ci.org/Gafurov0ivan/MobileAutorisationApi) 

## Мобильное API для регистрации и авторизации пользователя

## Запуск приложения
В корне проекта команда:  mvn spring-boot:run

## Доступ к приложению
Доступно по адресу http://localhost:8080/swagger-ui.html
Swagger позволяет наглядно просматривать API и провести простое тестирование

## Технологии
Java, Spring-boot, Spring-data, Spring-security, Hibernate, встроенная база данных hsql.

## Дополнительно
Код авторизации для ограничения доступа к рест сервисам, приходящий при подтверждении регистрации и логине 
на данный момент не используется, чтобы позволить протестировать данные API