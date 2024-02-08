package ru.nikitinia.integrationtests.autocodecache.apivehicle;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nikitinia.integrationtests.autocodecache.settings.AutoCodeCacheApiSettings;
import ru.nikitinia.integrationtests.logicwrapper.PropertyWrapper;
import ru.nikitinia.integrationtests.model.autococache.autocache.main.AutoCodeCacheApiVehicleRequest;
import ru.nikitinia.integrationtests.model.autococache.autocache.main.AutoCodeCacheApiVehicleResponse;
import ru.nikitinia.integrationtests.service.authorization.KeycloakAuthorize;
import ru.nikitinia.integrationtests.service.providesecrets.autocache.VaultAutocacheHandler;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_NOT_ACCEPTABLE;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isOneOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static ru.nikitinia.integrationtests.autocodecache.autocodecacheconstant.TestConstantsAutoCodeCache.ApiVehicleInfoData.AUTO_CODE_CACHE_DESCRIPTION;
import static ru.nikitinia.integrationtests.logicwrapper.ResourceHelper.loadJsonData;

@Epic(DESCRIPTION)
@Feature(DESCRIPTION)
class SomeService extends ApiSettings {

    private static String token;

    private static final String basePath =
            PropertyWrapper.getProperty().configProperty().Path();


    @BeforeAll
    static void getAuthData() {
        token = Authorize
                .getTokenByClientIdGrantTypeClientSecret(VaultHandler.handle());
    }

    @Test
    @Story(DESCRIPTION)
    @DisplayName(DESCRIPTION)
    void someService_shouldReturnResult() {

        Request request =
                jsonStaticObject.fromJson(
                        loadJsonData("pathToRequest.json"),
                        ClassObject.class);

        Response response =
                jsonStaticObject.fromJson(
                        loadJsonData("pathToResponse.json"),
                        ClassObject.class);

        testCase;

    }

}
