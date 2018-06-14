package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Source {

    enum Type {
        CSV,
        XML,
        JSON,
        EXCEL
    }

    Type type() default Type.CSV;
    String value() default "";
}
