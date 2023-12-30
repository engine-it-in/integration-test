package ru.nikitinia.integrationtests.model.someservice;

import java.util.List;

/**
 * Объект ответа
 *
 */
public record Response(

        String DecisionID,

        List<Check> checkList

) {
}
