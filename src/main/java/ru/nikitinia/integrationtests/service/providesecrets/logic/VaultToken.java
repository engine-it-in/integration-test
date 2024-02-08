package ru.nikitinia.integrationtests.service.providesecrets.logic;

import io.restassured.RestAssured;
import lombok.experimental.UtilityClass;
import ru.nikitinia.integrationtests.logicwrapper.PropertyWrapper;
import ru.nikitinia.integrationtests.model.vault.VaultData;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static ru.nikitinia.integrationtests.util.constant.Constant.VaultData.VaultToken.ResponseData.PATH_TO_TOKEN;

@UtilityClass
public class VaultToken {


    /**
     * Получить токен в vault
     *
     * @param vaultData - объект с параметрами доступа в vault
     * @return токен в vault
     */
    public static String getToken(VaultData vaultData) {

        return RestAssured.given()
                .contentType(APPLICATION_JSON_VALUE)
                .body(vaultData)
                .when()
                .post(PropertyWrapper.getProperty().configProperty().vaultLoginUrl())
                .jsonPath()
                .getString(PATH_TO_TOKEN);
    }

}
