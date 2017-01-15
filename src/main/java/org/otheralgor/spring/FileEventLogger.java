package org.otheralgor.spring;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;


/**
 * {@code FileEventLogger} class write log to file
 *
 * @author inoob
 * @see org.otheralgor.spring.FileEventLogger
 * @since 1.0
 */
public class FileEventLogger implements EventLogger{
    @Value("file:/Volumes/data/Code/Java/alghor/src/main/resources/log.txt")
    String fileName;
    Event event;
    File file;

    public FileEventLogger(Event event){
        //this.fileName = fileName;
        this.event = event;
    }

    /**
     * init method check file write access
     *
     * @throws IOException
     *      if file haven't access to write
     */
    public void init() throws IOException{
        this.file = new File("src/main/resources/log.txt");
        if (!file.canWrite()){
            throw new IOException();
        }
    }

    @Override
    public void loggEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
