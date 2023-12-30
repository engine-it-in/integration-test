package ru.nikitinia.integrationtests.someService.settings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import ru.nikitinia.integrationtests.property.PropertyWrapper;
import ru.nikitinia.integrationtests.util.RequestMediator;

public class Settings {

    protected static final ObjectMapper objectStaticMapper =
            new ObjectMapper();


    protected static final Gson jsonStaticObject =
            new Gson();

    @BeforeAll
    static void setRequestSpecification() {
        RequestMediator.initRequestSpecification(PropertyWrapper.getProperty().serviceUrl());
    }

}
