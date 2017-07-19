package javase02.t07;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by daddyingrave on 30/06/2017.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SubmarineClass {

    String name();

}
