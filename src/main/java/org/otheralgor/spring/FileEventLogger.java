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
    String fileName;
    Event event;
    File file;

    public FileEventLogger(Event event,String fileName){
        this.fileName = fileName;
        this.event = event;
    }

    /**
     * init method check file exist and file write access
     *  if file not exist it will be created
     * @throws IOException
     *      if file haven't access to write
     */
    public void init() throws IOException{
        this.file = new File(fileName);
        if (file.exists() && !file.canWrite()){
            throw new IOException();
        }
    }

    /**
     * Write event message to file
     * @param event
     *       get event
     */
    @Override
    public void loggEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
