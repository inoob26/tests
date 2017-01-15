package org.otheralgor.spring;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger{
    int cacheSize;
    List<Event> cache;

    public CacheFileEventLogger(int size ,String fileName, Event event) {
        super( event);
        this.cacheSize = size;
    }

    public void loggEvent(Event event){
        cache.add(event);

        if (cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        try {
            for (Event event : cache) {
                FileUtils.writeStringToFile(file, event.toString(), true);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
