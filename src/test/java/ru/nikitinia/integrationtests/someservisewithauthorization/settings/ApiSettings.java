package ru.alfastrah.odm.integrationtests.autocodecache.settings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeAll;
import ru.alfastrah.odm.integrationtests.logicwrapper.PropertyWrapper;
import ru.alfastrah.odm.integrationtests.model.config.XMLGregorianCalendarTypeAdapter;

import javax.xml.datatype.XMLGregorianCalendar;

import static ru.alfastrah.odm.integrationtests.logicwrapper.RequestMediator.initRequestSpecification;

public class AutoCodeCacheApiSettings {

    protected static final ObjectMapper objectStaticMapper =
            new ObjectMapper();

    protected static final Gson jsonStaticObject =
            new GsonBuilder()
                    .registerTypeAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarTypeAdapter())
                    .create();

    @BeforeAll
    static void setRequestSpecification() {
        initRequestSpecification(PropertyWrapper.getProperty().configProperty().autoCodeCacheApiUrl());
    }

}
