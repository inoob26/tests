package org.otheralgor.annotation;

import java.lang.annotation.*;


@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Target(value = ElementType.METHOD)
@Documented
public @interface Init {
    String name();

    boolean suppressException() default false;
}
