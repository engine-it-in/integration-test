package ru.nikitinia.integrationtests.util;

import com.google.common.io.Resources;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

@Slf4j
@UtilityClass
public class ResourceHelper {

    /**
     * Загрузить содержимое файла из папки
     *
     * @param resourceFile - путь к файлу
     * @return содержимое файла
     */
    public static String loadJsonData(String resourceFile) {
        String resourceContent = null;
        try {
            resourceContent = Resources.toString(
                    Resources.getResource(resourceFile),
                    StandardCharsets.UTF_8
            );
        } catch (Exception e) {
            log.error("Unable to load resource {}: {}", resourceFile, e.getMessage());
        }
        return resourceContent;
    }
}
