package ru.nikitinia.integrationtests.someServiseWithAuthorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeAll;
import ru.nikitinia.integrationtests.logicwrapper.PropertyWrapper;
import ru.nikitinia.integrationtests.model.config.XMLGregorianCalendarTypeAdapter;

import javax.xml.datatype.XMLGregorianCalendar;

import static ru.nikitinia.integrationtests.logicwrapper.RequestMediator.initRequestSpecification;

public class ApiSettings {

    protected static final ObjectMapper objectStaticMapper =
            new ObjectMapper();

    /*Add specific serializer*/
    protected static final Gson jsonStaticObject =
            new GsonBuilder()
                    .registerTypeAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarTypeAdapter())
                    .create();

    @BeforeAll
    static void setRequestSpecification() {
        initRequestSpecification(PropertyWrapper.getProperty().configProperty().someServiceUrl());
    }

}
