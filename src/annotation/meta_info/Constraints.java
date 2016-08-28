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
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    boolean primaryKey() default false;

    boolean nullAble() default true;

    boolean unique() default false;

    boolean autoIncrement() default false;
}