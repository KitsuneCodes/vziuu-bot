package KitsuneCodes.addons;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * @author Paqlio
 * @since 07.28.2023 - 12:26
 **/
public class Config {
    private static final Dotenv dotenv = Dotenv.configure()
            .directory("src/main/java/KitsuneCodes/addons")
            .filename("env")
            .load();

    public static String get(String key) {
        return dotenv.get(key.toUpperCase());
    }
}
