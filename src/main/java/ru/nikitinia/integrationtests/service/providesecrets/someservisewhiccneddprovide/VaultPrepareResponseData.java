package ru.alfastrah.odm.integrationtests.service.providesecrets.autocache;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import ru.alfastrah.odm.integrationtests.exception.ProcessingException;
import ru.alfastrah.odm.integrationtests.model.vault.AuthParam;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static ru.alfastrah.odm.integrationtests.util.constant.Constant.VaultData.VaultFolderData.ResponseProcessingData.DELIMITER_STRING;
import static ru.alfastrah.odm.integrationtests.util.constant.Constant.VaultData.VaultFolderData.ResponseProcessingData.DELIMITER_VALUE;
import static ru.alfastrah.odm.integrationtests.util.constant.Constant.VaultData.VaultFolderData.ResponseProcessingData.DOT;
import static ru.alfastrah.odm.integrationtests.util.constant.Constant.VaultData.VaultFolderData.ResponseProcessingData.END_STRING;
import static ru.alfastrah.odm.integrationtests.util.constant.Constant.VaultData.VaultFolderData.ResponseProcessingData.PATH_TO_DATA;
import static ru.alfastrah.odm.integrationtests.util.constant.Constant.VaultData.VaultFolderData.ResponseProcessingData.START_STRING;

@UtilityClass
public class VaultPrepareResponseData {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Обработка конкретных параметров, добавленных в vault
     *
     * @param response - содержимое конкретной папки
     * @return объект с параметрами папки vault
     */
    public static AuthParam processingAutoCacheAuthData(Response response) {

        String[] vaultDataAuthList =
                VaultPrepareAutocacheResponseData.vaultPrepareDataFromAutocacheFolder(response);

        Map<String, String> authData =
                VaultPrepareAutocacheResponseData.prepareDataToMapObject(vaultDataAuthList);

        return objectMapper
                .convertValue(authData, AuthParam.class);
    }

    private static String[] vaultPrepareDataFromAutocacheFolder(Response response) {
        return new JsonPath(response.getBody().asString())./*some logic to processing data*/;
    }

    private static Map<String, String> prepareDataToMapObject(String[] strings) {

        try {
            /* Some logic to prepare data*/
            return data;
        } catch (RuntimeException exception) {
            throw new ProcessingException(
                    String.format(
                            "Ошибка при обработке параметров folder из Vault: %s", exception.getMessage())
            );
        }
    }

}
