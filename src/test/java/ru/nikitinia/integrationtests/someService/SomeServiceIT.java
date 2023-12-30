package ru.nikitinia.integrationtests.someService;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nikitinia.integrationtests.model.someservice.Request;
import ru.nikitinia.integrationtests.model.someservice.Response;
import ru.nikitinia.integrationtests.someService.settings.Settings;
import ru.nikitinia.integrationtests.someService.constant.TestConstantsSomeServiceIT;
import ru.nikitinia.integrationtests.util.ResourceHelper;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Epic(TestConstantsSomeServiceIT.ServiceData.UNIVERSAL_DESCRIPTION)
@Feature("Поиск данных")
class SomeServiceIT extends Settings {

    @Test
    @Story("Получение данных по физическим лицам")
    @DisplayName("Успешная загрузка данных")
    void universalCheck_check4s_shouldReturnSuccessResult() throws JsonProcessingException {

        Request request =
                jsonStaticObject.fromJson(
                        ResourceHelper.loadJsonData("json/someService/someMethod/success/request.json"),
                        Request.class);

        Response universalCheckResponse =
                jsonStaticObject.fromJson(
                        ResourceHelper.loadJsonData("json/someService/someMethod/success/response.json"),
                        Response.class);

        String response = given()
                .body(request)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(HTTP_OK)
                .contentType(APPLICATION_JSON_VALUE)
                .body("DecisionID", equalTo(universalCheckResponse.DecisionID()))
                .body("checkList[0].checkName", equalTo(universalCheckResponse.checkList().get(0).checkName()))
                .body("checkList[0].processAttempt", equalTo(universalCheckResponse.checkList().get(0).processAttempt()))
                .extract().asString();

        String expectedJson =
                objectStaticMapper.writeValueAsString(universalCheckResponse);

        assertEquals(response, expectedJson);
    }

    @Test
    @Story("Получение данных по физическим лицам")
    @DisplayName("Не успешная загрузка данных")
    void universalCheck_check4s_shouldReturnException() throws JsonProcessingException {

        Request request =
                jsonStaticObject.fromJson(
                        ResourceHelper.loadJsonData("json/someService/someMethod/fail/request.json"),
                        Request.class);

        Response universalCheckResponse =
                jsonStaticObject.fromJson(
                        ResourceHelper.loadJsonData("json/someService/someMethod/fail/response.json"),
                        Response.class);

        String response = given()
                .body(request)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(HTTP_OK)
                .contentType(APPLICATION_JSON_VALUE)
                .body("DecisionID", equalTo(universalCheckResponse.DecisionID()))
                .body("checkList[0].checkName", equalTo(universalCheckResponse.checkList().get(0).checkName()))
                .body("checkList[0].processAttempt", equalTo(universalCheckResponse.checkList().get(0).processAttempt()))
                .extract().asString();

        String expectedJson =
                objectStaticMapper.writeValueAsString(universalCheckResponse);

        assertEquals(response, expectedJson);
    }

}