import org.junit.Test;
import org.otheralgor.annotation.Init;
import org.otheralgor.annotation.LazyService;
import org.otheralgor.annotation.SimpleService;
import org.otheralgor.annotation.StandartService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AnnotationTest {

    private Map<String,Object> serviceMap = new HashMap<>();

    @Test
    public void testAnnotation(){
        checkService(new StandartService());
        checkService(new LazyService());
        checkService(new String());
    }

    public void checkService(Object service){
        if (service.getClass().isAnnotationPresent(SimpleService.class)){
            System.out.println("good");
            Method[] methods = service.getClass().getMethods();
            for (Method m: methods){
                Init i = m.getAnnotation(Init.class);
                if (i != null){
                    System.out.println(m.getName());
                }else {
                    System.out.println("Init annotation didn't present");
                }
            }
        }else {
            System.out.println("SimpleService annotation didn't present");
        }
    }

    @Test
    public void testLoadService(){
        loadService("org.otheralgor.annotation.StandartService");
        loadService("org.otheralgor.annotation.LazyService");
        loadService("java.lang.String");

        System.out.println(serviceMap);

        Method[] methods;
        Object serviceObj = null;
        for (Map.Entry<String,Object> s: serviceMap.entrySet() ) {
            try {
                serviceObj = s.getValue().getClass().newInstance();
                methods = serviceObj.getClass().getMethods();
                for (int i = 0; i < methods.length; i++) {
                    if (methods[i].isAnnotationPresent(Init.class)){
                        try {
                            methods[i].invoke(serviceObj);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("Init annotation didn't present");
                    }
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            /*methods = s.getClass().getMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].isAnnotationPresent(Init.class)){
                    try {
                        methods[i].invoke(serviceObj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("Init annotation didn't present");
                }
            }*/
        }
    }

    public void loadService(String className){
        Objects.requireNonNull(className,"Name must be not NULL");
        try {
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(SimpleService.class)){
                Object service  = clazz.newInstance();
                serviceMap.put(className,service);
            } else {
                System.out.println("SimpleService annotation didn't present");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
