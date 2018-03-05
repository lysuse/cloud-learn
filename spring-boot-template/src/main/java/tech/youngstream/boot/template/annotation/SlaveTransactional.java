package tech.youngstream.boot.template.annotation;

import java.lang.annotation.*;

/**
 * 从数据库事务
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SlaveTransactional {

}
