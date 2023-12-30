package ru.nikitinia.integrationtests.property;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import ru.nikitinia.integrationtests.model.configproperty.Property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
@UtilityClass
public class PropertyWrapper {
    private static final ObjectMapper objectMapper
            = new ObjectMapper();

    /**
     * Получить значения из config.properties
     *
     * @return Property объект
     */
    public static Property getProperty() {
        log.info("Load properties file config.properties");
        return objectMapper.convertValue(
                loadPropertiesFromFile("config.properties"),
                Property.class);
    }

    /**
     * Загрузить содержимое файла
     *
     * @param fileProperties - название файла с properties
     * @return содержимое файла
     */
    private static Properties loadPropertiesFromFile(String fileProperties) {

        Properties properties = new Properties();

        try (InputStream resourceAsStream =
                     PropertyWrapper.class.getClassLoader()
                             .getResourceAsStream(fileProperties)) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            log.error("Unable to load properties file : {} ", fileProperties);
        }
        return properties;
    }

}