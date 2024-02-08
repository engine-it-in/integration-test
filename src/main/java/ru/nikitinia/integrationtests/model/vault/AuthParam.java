package ru.nikitinia.integrationtests.model.vault;

import lombok.Builder;


/**
 * Объект для работы с атрибутами, необходимыми для аутентификации
 */
@Builder
public record AuthParam(

        String tokenClientId,

        String tokenClientSecret,

        String tokenGrantType

) {
}
