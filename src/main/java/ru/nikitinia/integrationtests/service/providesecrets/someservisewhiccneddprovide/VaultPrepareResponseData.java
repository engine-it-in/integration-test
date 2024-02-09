package ru.nikitinia.integrationtests.service.providesecrets.someservisewhiccneddprovide;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import ru.nikitinia.integrationtests.exception.ProcessingException;
import ru.nikitinia.integrationtests.model.vault.AuthParam;

import java.util.Map;

@UtilityClass
public class VaultPrepareResponseData {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Обработка конкретных параметров, добавленных в vault
     *
     * @param response - содержимое конкретной папки
     * @return объект с параметрами папки vault
     */
    public static AuthParam processingAuthData(Response response) {

        String[] vaultDataAuthList =
                VaultPrepareResponseData.vaultPrepareDataFromFolder(response);

        Map<String, String> authData =
                VaultPrepareResponseData.prepareDataToMapObject(vaultDataAuthList);

        return objectMapper
                .convertValue(authData, AuthParam.class);
    }

    private static String[] vaultPrepareDataFromFolder(Response response) {
        return new JsonPath(response.getBody().asString()).get() /*some logic to processing data*/;
    }

    private static Map<String, String> prepareDataToMapObject(String[] strings) {

        try {

            /* Some logic to prepare data
             * return data;
             * */
        } catch (RuntimeException exception) {
            throw new ProcessingException(
                    String.format(
                            "Ошибка при обработке параметров folder из Vault: %s", exception.getMessage())
            );
        }
    }

}
