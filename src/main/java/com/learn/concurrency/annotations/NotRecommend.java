package com.learn.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @AnnotationName ThreadSafe
 * @Description 标记不推荐的类或写法
 * @Author penelope
 * @Date 2018-09-05 17:50
 * @Version 1.0
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotRecommend {

    String value() default "";
}
