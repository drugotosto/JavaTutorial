package ferrero.com.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface MyClassInfoAnnotation {
	String author() default "Maury";
	String date();
	String[] reviewers() default {"Maury"};
	String comment();
}