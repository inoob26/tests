package org.otheralgor.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * {@code Application} class have 3 fields
 * {@code Client client} field keep information about Cleint
 * {@code ConsoleEventLogger client} field using for logging
 * {@code Event event} keep message and date event
 *
 * @author inoob
 * @see org.otheralgor.spring.Application
 * @since 1.0
 */

public class Application {
    Client client;
    ConsoleEventLogger eventLogger;
    Event event;

    /**
     * @param client get Client for logging information about his event
     * @param logger
     * @param event
     */
    public  Application(Client client,ConsoleEventLogger logger,Event event){
        this.client = client;
        this.eventLogger = logger;
        this.event = event;
    }

    public Application() {
    }

    /**
     * If client have id method will replace the id with fullName
     * @param msg
     *          message for logging
     */
    public void loggEvent(String msg){
        String message = msg.replaceAll(String.valueOf(client.getId()),client.getFullName());
        event.setMsg(message);
        eventLogger.loggEvent(event);
    }

}
