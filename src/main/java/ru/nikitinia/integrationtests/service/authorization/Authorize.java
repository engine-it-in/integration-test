package ru.nikitinia.integrationtests.service.authorization;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import ru.nikitinia.integrationtests.logicwrapper.PropertyWrapper;
import ru.nikitinia.integrationtests.model.vault.AuthParam;

import static ru.nikitinia.integrationtests.util.constant.Constant.kData.RequestData.CLIENT_ID;
import static ru.nikitinia.integrationtests.util.constant.Constant.kData.RequestData.CLIENT_SECRET;
import static ru.nikitinia.integrationtests.util.constant.Constant.kData.RequestData.CONTENT_TYPE_URLENCODED;
import static ru.nikitinia.integrationtests.util.constant.Constant.kData.RequestData.GRANT_TYPE;
import static ru.nikitinia.integrationtests.util.constant.Constant.kData.ResponseData.ACCESS_TOKEN;

@UtilityClass
public class Authorize {

    /**
     * Получить токен доступа из авторизационного провайдера
     *
     * @param authParam - объект с переменными запроса, полученными из провайдера секретов
     * @return token, извлеченный из ответа авторизационного провайдера
     */
    public static String getTokenByClientIdGrantTypeClientSecret(AuthParam authParam) {

        Response response = RestAssured.given()
                .contentType(CONTENT_TYPE_URLENCODED)
                .param(CLIENT_ID, authParam.tokenClientId())
                .param(GRANT_TYPE, authParam.tokenGrantType())
                .param(CLIENT_SECRET, authParam.tokenClientSecret())
                .post(PropertyWrapper.getProperty().configProperty().tokenUrl());

        return new JsonPath(response.getBody().asString())
                .getString(ACCESS_TOKEN);

    }

}
