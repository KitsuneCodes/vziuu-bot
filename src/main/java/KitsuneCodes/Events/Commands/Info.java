package KitsuneCodes.Events.Commands;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Paqlio
 * @since 07.28.2023 - 12:53
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface Info {
    String name();
    String description();
}
