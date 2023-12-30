package ru.nikitinia.integrationtests.model.someservice;

import java.util.List;

public record CheckList(

        String checkName,

        Boolean checkSuccess,

        Boolean processAttempt,

        List<Parameter> parameter,

        List<Parameter> checkResult

) {
}
