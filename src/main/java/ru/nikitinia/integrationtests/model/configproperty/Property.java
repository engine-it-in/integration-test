package ru.nikitinia.integrationtests.model.configproperty;

import lombok.Builder;

/**
 * Объект для работы с: 
 *  конфигурационными переменными - ConfigProperty (config.properties)
 *  системными переменными - environmentProperty (env.properties)
 */
@Builder
public record Property(
        ConfigProperty configProperty,
        EnvironmentProperty environmentProperty

) {
}
