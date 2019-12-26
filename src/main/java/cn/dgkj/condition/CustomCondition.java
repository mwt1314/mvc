package cn.dgkj.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author mawt
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(CustomSpringBootCondition.class)
public @interface CustomCondition {

    String value();

}
