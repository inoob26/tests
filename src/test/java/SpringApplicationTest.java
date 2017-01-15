import org.junit.Before;
import org.junit.Test;
import org.otheralgor.spring.Application;
import org.otheralgor.spring.Event;
import org.otheralgor.spring.FileEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.util.Date;

public class SpringApplicationTest {

    ApplicationContext applicationContext;

    @Test
    public void testApplication(){
        Application application = applicationContext.getBean(Application.class);
        application.loggEvent("Some event for user 1");
    }

    @Test
    public void testFileEventLogger(){
        FileEventLogger fileEventLogger = applicationContext.getBean(FileEventLogger.class);

        Event event = new Event(new Date(), DateFormat.getDateInstance());
        event.setMsg("1234");
        fileEventLogger.loggEvent(event);
    }

    @Before
    public void init(){
        applicationContext
                = new ClassPathXmlApplicationContext("spring.xml");
    }
}
