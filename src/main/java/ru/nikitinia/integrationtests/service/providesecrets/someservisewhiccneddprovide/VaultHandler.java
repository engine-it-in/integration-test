package ru.nikitinia.integrationtests.service.providesecrets.someservisewhiccneddprovide;

import lombok.experimental.UtilityClass;
import ru.nikitinia.integrationtests.logicwrapper.PropertyWrapper;
import ru.nikitinia.integrationtests.model.vault.AuthParam;
import ru.nikitinia.integrationtests.service.providesecrets.logic.VaultFolderData;

import static ru.nikitin.integrationtests.service.providesecrets.autocache.VaultPrepareResponseData.processingAuthData;


@UtilityClass
public class VaultHandler {

    /**
     * Обработка конкретных параметров папки с параметрами к autocache
     *
     * @return объект с параметрами аутентификации
     */
    public static AuthParam handle() {

        ru.alfastrah.odm.integrationtests.model.vault.VaultData vaultData = ru.alfastrah.odm.integrationtests.model.vault.VaultData.builder()
                .role_id(PropertyWrapper.getProperty().environmentProperty().vaultRoleId())
                .secret_id(PropertyWrapper.getProperty().environmentProperty().vaultSecretId())
                .build();

        return processingAuthData(VaultFolderData.getResponseVaultFolderData(vaultData));

    }
}
