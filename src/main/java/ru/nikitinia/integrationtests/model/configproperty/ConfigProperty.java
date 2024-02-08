package ru.alfastrah.odm.integrationtests.model.configproperty;

/**
 * Объект для работы с:
 *  конфигурационными переменными - ConfigProperty (config.properties)
 */
public record ConfigProperty(

        /*Среда*/
        String environment,
        /*Url для подключения к бизнес сервису*/
        String someServiceUrl,
        /*Url для подключения к савторизационному провайдеру*/
        String tokenUrl
  
) {
}
