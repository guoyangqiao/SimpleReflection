package annotation.meta_info;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 8/28/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@SQLComponent("varchar")
public @interface SQLString {

    String defaultValue() default "null";

    int length() default 255;

    Constraints constraints() default @Constraints;
}