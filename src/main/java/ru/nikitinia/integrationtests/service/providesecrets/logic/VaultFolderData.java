package ru.nikitinia.integrationtests.service.providesecrets.logic;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import ru.nikitinia.integrationtests.logicwrapper.PropertyWrapper;
import ru.nikitinia.integrationtests.model.vault.VaultData;

import static ru.nikitinia.integrationtests.util.constant.Constant.VaultData.VaultFolderData.RequestData.HEADER_TOKEN_VAULT;

@UtilityClass
public class VaultFolderData {

    /**
     * Данные из папки vault
     *
     * @param vaultData - объект с параметрами запроса данных в vault
     * @return Содержимое папки
     */
    public static Response getResponseVaultFolderData(VaultData vaultData) {

        return RestAssured.given()
                .header(new Header(HEADER_TOKEN_VAULT, VaultToken.getToken(vaultData)))
                .get(PropertyWrapper.getProperty().configProperty().vaultDataFolderUrl());
    }

}
