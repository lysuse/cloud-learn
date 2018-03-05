package tech.youngstream.boot.template.annotation;

import java.lang.annotation.*;

/**
 * 主从混合式事务
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MixedTransactional {
}
