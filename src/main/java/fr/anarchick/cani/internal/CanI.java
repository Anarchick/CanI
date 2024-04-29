package fr.anarchick.cani.internal;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Used when a method contain canI events.
 * You have to specify the events class that are used in the method.
 */
@Documented
@Target(ElementType.METHOD)
public @interface CanI {

    Class<? extends CanIEvent>[] value();

}
