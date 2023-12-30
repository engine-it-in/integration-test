package ru.nikitinia.integrationtests.util;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.requestSpecification;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@UtilityClass
public class RequestMediator {

    /**
     * Настройка спецификатора для выполнения запросов Rest Assured
     * Настройка для логирования запроса/ответа, если валидация была не успешна
     *
     * @param uri - путь выполнения запроса
     */
    public static void initRequestSpecification(String uri) {
        requestSpecification = new RequestSpecBuilder()
                .setContentType(APPLICATION_JSON_VALUE)
                .setBaseUri(uri)
                .build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        if (RestAssured.filters().isEmpty()) {
            RestAssured.filters(new AllureRestAssured());
        }
    }

}