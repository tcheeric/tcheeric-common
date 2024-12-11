package xyz.tcheeric.common.config;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Configuration {

    private final @NonNull String prefix;

    public String get(@NonNull String key) {
        return PropertiesWrapper.getProperty(prefix + "." + key);
    }

    public String get(@NonNull String key, @NonNull String defaultValue) {
        return PropertiesWrapper.getProperty(prefix + "." + key, defaultValue);
    }
}
