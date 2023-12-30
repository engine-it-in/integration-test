package ru.nikitinia.integrationtests.model.someservice;

import java.util.List;

public record Check(

        String checkName,
        Boolean checkSuccess,
        List<Parameter> checkResult,
        List<Parameter> parameter,
        Boolean processAttempt

) {
}
