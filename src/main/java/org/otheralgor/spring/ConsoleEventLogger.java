package org.otheralgor.spring;


/**
* The {@code ConsoleEventLogger} class need for logging
 * it have only 1 method for printing {@code String message} on the screen
 *
 * @author inoob
 * @see org.otheralgor.spring.ConsoleEventLogger
 * @since 1.0
* */
public class ConsoleEventLogger implements EventLogger {
    public void loggEvent(Event event){
        System.out.println(event.toString());
    }
}
