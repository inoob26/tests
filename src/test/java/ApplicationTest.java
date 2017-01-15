import org.junit.Test;
import org.otheralgor.*;
import org.otheralgor.collections.SimpleLRUCache;
import org.otheralgor.cuncurrency.Account;
import org.otheralgor.cuncurrency.Transfer;
import org.otheralgor.lambda.Macintosh;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/*
public class ApplicationTest {
    @Test
    public void tt(){
        Collection<SportCamp> sportCamps = Arrays.asList(
                new SportCamp("Ilya",5),
                new SportCamp("Ira",15),
                new SportCamp(null,50),
                new SportCamp("Sacha",4),
                new SportCamp("Ivan",10)
        );

        SportCamp name = sportCamps.stream()
                .filter( (p) -> p.getName() != null )
                .min( (p1,p2) -> p1.getCountDay().compareTo(p2.getCountDay()) )
                .get();

        System.out.println("Minimum Count day in Camp " + name.toString());

        List<SportCamp> sportCampList = sportCamps.stream()
                .filter( (p) -> p.getName() != null && p.getName().startsWith("I"))
                .collect(Collectors.toList());
        System.out.println(sportCampList.size());
        String campName = sportCampList.stream()
                .filter((p) -> p.getName() != null)
                .map(SportCamp::getName)
                .collect(Collectors.joining(" and ","In camp "," rest all days."));
        System.out.println(campName);



    }

    @Test
    public void testGenerics(){

        Gen<Integer> iOb = new Gen<>(new Integer[]{88,15,72,1});
        System.out.println(iOb.getAverage());
        Gen<Double> doubleGen = new Gen<>(new Double[]{88.0,15.0,72.0,1.0});

        if (iOb.isSame(88,88)){
            System.out.println("true");
        }


        System.out.println("Does double and integer the same?");
        System.out.println(iOb.sameAvg(doubleGen));
    }

    @Test
    public void testGenList(){
        List rawList = new ArrayList();
        List<String> list = new ArrayList<>();

        rawList = list;

        rawList.add(8);
        System.out.println(rawList.get(0).toString());

        List<Camera> cameras = new ArrayList<>();
        List<Product> phones = new ArrayList<>();

        cameras.add(0,new Camera(100));
        cameras.add(1,new Camera(200));

        copy(cameras,phones);

        Phone phone1 = new Phone("samsung GA155");
        Phone phone2 = new Phone("samsung GA156");

        Comparator<Phone> phoneComparator = (p1, p2) -> Comparator.comparing(Phone::getModel).compare(p1,p2);



    }

    public void copy (List<? extends Product> src, List<? super Product> dest){
        for (Product p : src) {
            dest.add( p);
        }

        for (int i = 0; i < dest.size(); i++) {
            System.out.println(dest.get(i).toString());
        }
    }


    @Test
    public void testComputer(){
        List<Macintosh> macintoshList = new ArrayList<>();

        macintoshList.add(0,new Macintosh("a1278"));
        macintoshList.add(1,new Macintosh("a1279"));
        macintoshList.add(2,new Macintosh("a1280"));

        macintoshList.stream()
                .filter((macintosh) -> macintosh.getModel().contains("79"))
                .forEach( (macintosh) -> System.out.println(macintosh.toString()));


        System.out.println(Objects.requireNonNull(new Macintosh("not null"),"msg").toString());
    }


    @Test
    public void testSynchronized(){


        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Account acc1 = new Account(1000);
        Account acc2 = new Account(2000);

        Random random = new Random();
        for (int i = 0; i< 3;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(new Transfer(acc1,acc2,random.nextInt(400),i,countDownLatch));
        }

        countDownLatch.countDown();

        executorService.shutdown();

    }


}

*/

