package ru.alfastrah.odm.integrationtests.model.vault;

import lombok.Builder;

/**
 * Объект для работы с атрибутами, необходимыми для подключения к хранилищу секретов
 */
@Builder
public record VaultData(

        String role_id,
        
        String secret_id

) {
}
