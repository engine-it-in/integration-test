package ru.nikitinia.integrationtests.logicwrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import ru.nikitinia.integrationtests.exception.ProcessingException;
import ru.nikitinia.integrationtests.model.configproperty.ConfigProperty;
import ru.nikitinia.integrationtests.model.configproperty.EnvironmentProperty;
import ru.nikitinia.integrationtests.model.configproperty.Property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

@Slf4j
@UtilityClass
public class PropertyWrapper {
    private static final ObjectMapper objectMapper
            = new ObjectMapper();

    /**
     * Получить значения из config.properties и env.properties
     *
     * @return Property объект
     */
    public static Property getProperty() {
        log.info("Load properties file config.properties");
        ConfigProperty configProperty = objectMapper.convertValue(
                loadPropertiesFromFile("config.properties"),
                ConfigProperty.class);

        log.info("Load environment properties env.properties");
        EnvironmentProperty environmentProperty = loadPropertiesFromEnv("env.properties");

        return Property.builder()
                .configProperty(configProperty)
                .environmentProperty(environmentProperty)
                .build();
    }

    /**
     * Загрузить содержимое файла
     *
     * @param fileProperties - название файла с конфигурационными переменными
     * @return содержимое файла
     */
    private static Properties loadPropertiesFromFile(String fileProperties) {

        Properties properties = new Properties();

        try (InputStream resourceAsStream =
                     PropertyWrapper.class.getClassLoader()
                             .getResourceAsStream(fileProperties)) {

            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new ProcessingException(
                    String.format("Ошибка при обработке конфигурационных переменных : %s", e.getMessage()));

        }
        return properties;
    }

    /**
     * Загрузить содержимое файла
     *
     * @param envPropertiesFile - название файла с системными переменными
     * @return содержимое файла
     */
    private static EnvironmentProperty loadPropertiesFromEnv(String envPropertiesFile) throws ProcessingException {

        Configurations configs = new Configurations();

        try {
            Configuration config = configs.properties(envPropertiesFile);
            for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
                config.setProperty(entry.getKey(), entry.getValue());
            }

            return EnvironmentProperty.builder()
                    .vaultAutoCacheSecretId(config.getString("vaultAutoCacheSecretId"))
                    .vaultAutoCacheRoleId(config.getString("vaultAutoCacheRoleId"))
                    .build();

        } catch (ConfigurationException e) {
            throw new ProcessingException(
                    String.format("Ошибка при обработке системных переменных : %s", e.getMessage()));
        }

    }

}
