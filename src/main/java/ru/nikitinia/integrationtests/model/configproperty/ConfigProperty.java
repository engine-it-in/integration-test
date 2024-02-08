package ru.alfastrah.odm.integrationtests.model.configproperty;

/**
 * Объект для работы с:
 *  конфигурационными переменными - ConfigProperty (config.properties)
 */
public record ConfigProperty(

        /*Среда*/
        String environment,
        /*Url для подключения к сервису*/
        String serviceUniversalCheckUrl
  
) {
}
