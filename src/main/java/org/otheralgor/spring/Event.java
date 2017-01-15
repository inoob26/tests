package org.otheralgor.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * {@code Event } class keep info about event
 * when it was, message and event id
 */

public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    /**
     * @param date keep date when event were
     * @param dateFormat it need for spin data to string format
     */
    public Event(Date date, DateFormat dateFormat) {
        Random random = new Random();
        id = random.nextInt();
        this.date = date;
        this.df = dateFormat;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(getDate()) +
                '}';
    }

    public Date getDate() {
        return date;
    }
}
