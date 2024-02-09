package ru.nikitinia.integrationtests.model.configproperty;

import lombok.Builder;

/**
 * Объект для работы с:
 *  Системными переменными - environmentProperty (env.properties)
 *  Например, данные для подключения к vault
 */
@Builder
public record EnvironmentProperty(
        String vaultRoleId,
        String vaultSecretId
) {
}
