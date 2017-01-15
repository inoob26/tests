package org.otheralgor.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SimpleService {
    String name();

    //public String name = null;

    boolean lazyLoad() default false;
}
