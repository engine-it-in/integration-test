package ru.nikitinia.integrationtests.model.config;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Type;


/**
 * Для работы с экзотическими типами нужно настроить сериализацию/десериализацию, ну или найти профильную бибилиотеку
 * Я решил настроить
 */
public class XMLGregorianCalendarTypeAdapter implements
        JsonSerializer<XMLGregorianCalendar>,
        JsonDeserializer<XMLGregorianCalendar> {

    @Override
    public JsonElement serialize(
            XMLGregorianCalendar src,
            Type typeOfSrc,
            JsonSerializationContext context) {
        return context.serialize(src.toGregorianCalendar());
    }

    @Override
    public XMLGregorianCalendar deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context)
            throws JsonParseException {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(json.getAsString());
        } catch (DatatypeConfigurationException e) {
            throw new JsonParseException(e);
        }
    }

}
