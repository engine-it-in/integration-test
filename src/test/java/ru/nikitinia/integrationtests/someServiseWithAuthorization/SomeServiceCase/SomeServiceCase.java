package ru.nikitinia.integrationtests.someServiseWithAuthorization.SomeServiceCase;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nikitinia.integrationtests.logicwrapper.PropertyWrapper;
import ru.nikitinia.integrationtests.model.someservice.Request;
import ru.nikitinia.integrationtests.model.someservice.Response;
import ru.nikitinia.integrationtests.service.authorization.Authorize;
import ru.nikitinia.integrationtests.someServiseWithAuthorization.ApiSettings;

import static ru.nikitinia.integrationtests.logicwrapper.ResourceHelper.loadJsonData;

@Epic("DESCRIPTION")
@Feature("DESCRIPTION")
class SomeService extends ApiSettings {

    private static String token;

    private static final String basePath =
            PropertyWrapper.getProperty().configProperty().someServiceUrl();


    @BeforeAll
    static void getAuthData() {
        token = Authorize
                .getTokenByClientIdGrantTypeClientSecret(ru.nikitinia.integrationtests.service.providesecrets.autocache.VaultHandler.handle());
    }

    @Test
    @Story("DESCRIPTION")
    @DisplayName("DESCRIPTION")
    void someService_shouldReturnResult() {

        Request request =
                jsonStaticObject.fromJson(
                        loadJsonData("pathToRequest.json"),
                        Request.class);

        Response response =
                jsonStaticObject.fromJson(
                        loadJsonData("pathToResponse.json"),
                        Response.class);
        /*
        testCase;
         */
    }

}
