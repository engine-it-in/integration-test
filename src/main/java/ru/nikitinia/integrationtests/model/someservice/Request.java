package ru.nikitinia.integrationtests.model.someservice;

import lombok.Builder;

import java.util.List;

/**
 * Объект запроса данных к сервису
 *
 */
@Builder
public record Request(

        String DecisionID,

        List<CheckList> checkList

) {
}
