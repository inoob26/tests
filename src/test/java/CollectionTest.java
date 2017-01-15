import org.junit.Test;
import org.otheralgor.collections.Consumer;
import org.otheralgor.collections.Producer;
import org.otheralgor.collections.ReadList;
import org.otheralgor.collections.SimpleLRUCache;

import java.io.ObjectOutputStream;
import java.util.*;
import java.util.concurrent.*;


public class CollectionTest {
    @Test
    public void testCollections(){
        SortedSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        System.out.println(set);


    }

    @Test
    public void testGetNextAndPrevElement(){
        NavigableSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        System.out.println(set.descendingSet());

        System.out.println(set.headSet(5));


    }

    @Test
    public void testMapCollections(){
        Map<Integer,String> map = new LinkedHashMap<>(5,1,true);
        /*
            Map<Integer,String> map = new HashMap<>();
            if we use this initialization we will get sequential output 1 2 3 4 5
            why ? order is not guaranteed in HashMap
            because int the Hashcode Key Integer return Integer
            but when it will be insert in the stack
            the order will not have guaranteed
         */


        map.put(5,"a");
        map.put(4,"b");
        map.put(3,"c");
        map.put(2,"d");
        map.put(1,"e");

        map.get(5);
        map.get(3);
        map.get(1);

        System.out.println(map);
    }

    @Test
    public void testLRU(){
        SimpleLRUCache<Integer,String> cache = new SimpleLRUCache<>(2);

        cache.put(1,"a");
        cache.put(2,"b");
        cache.put(3,"c");

        cache.get(2);

        cache.put(9,"z");

        System.out.println(cache);
    }

    @Test
    public void testWeakHash(){
        Map<Object,String> map = new WeakHashMap<Object, String>();

        Object data = new Object();
        map.put(data,"information");

        data = null;
        System.gc();

        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            if(map.isEmpty()){
                System.out.println("Empty!");
                break;
            }
        }
    }

    @Test
    public void testQueue(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);

        Queue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if ((o1 %2) == 0){
                    return cpm(o2,o1);
                } else {
                    return cpm(o1,o2);
                }
            }
        });
        queue1.add(5);
        queue1.add(2);
        queue1.add(1);
        queue1.add(4);

        while (!queue1.isEmpty()){
            System.out.println(queue1.poll());
        }
    }

    public int cpm(int o1, int o2){
        if (o1 == o2){
            return 0;
        }

        if (o1 < o2 ){
            return -1;
        }else return 1;
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIterator(){
        List<Integer> list = new ArrayList<>();

        list.add(0,1);

        Iterator<Integer> iterator = list.iterator();
        if (iterator.hasNext()){
            list.add(1,1);
        }
    }


    @Test
    public void testCopyOnWriteArrayListAndSynchronizedArrayList(){
        List<Integer> list1 = Collections.synchronizedList(new ArrayList<Integer>());

        List<Integer> list2 = new CopyOnWriteArrayList<>();

        fillList(list1);
        fillList(list2);

        readList(list1);
        readList(list2);
    }

    public void fillList(List list){
        for (int i = 0; i < 100; i++) {
            list.add(i,i);
        }
    }

    public void readList(List<Integer> list){
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService ex = Executors.newFixedThreadPool(2);

        Future<Long> f1 = ex.submit(new ReadList(list, latch, 0, 50));
        Future<Long> f2 = ex.submit(new ReadList(list, latch, 50, 100));

        latch.countDown();

        try {
            System.out.println("Thread 1: " + f1.get() / 1000);
            System.out.println("Thread 2: " + f2.get() / 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSynchronousQueue(){
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService ex = Executors.newFixedThreadPool(2);

        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        Producer producer = new Producer(queue,latch);

        Consumer consumer = new Consumer(queue,latch);

        Future<?> f1 = ex.submit(producer);
        Future<?> f2 = ex.submit(consumer);

        latch.countDown();

        try {
            System.out.println("Thread 1: " + f1.get() );
            System.out.println("Thread 2: " + f2.get() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
