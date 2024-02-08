package ru.alfastrah.odm.integrationtests.service.providesecrets.autocache;

import lombok.experimental.UtilityClass;
import ru.alfastrah.odm.integrationtests.logicwrapper.PropertyWrapper;
import ru.alfastrah.odm.integrationtests.model.vault.AuthParam;
import ru.alfastrah.odm.integrationtests.model.vault.VaultData;
import ru.alfastrah.odm.integrationtests.service.providesecrets.logic.VaultFolderData;

import static ru.alfastrah.odm.integrationtests.service.providesecrets.autocache.VaultPrepareAutocacheResponseData.processingAutoCacheAuthData;

@UtilityClass
public class VaultAutocacheHandler {

    /**
     * Обработка конкретных параметров папки с параметрами к autocache
     *
     * @return объект с параметрами аутентификации
     */
    public static AuthParam handle() {

        VaultData vaultData = VaultData.builder()
                .role_id(PropertyWrapper.getProperty().environmentProperty().vaultAutoCacheRoleId())
                .secret_id(PropertyWrapper.getProperty().environmentProperty().vaultAutoCacheSecretId())
                .build();

        return processingAutoCacheAuthData(VaultFolderData.getResponseVaultFolderData(vaultData));

    }
}
