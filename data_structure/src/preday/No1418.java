package preday;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 *
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 *
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 *
 */
public class No1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        if(orders.size()==0){
            return ans;
        }
        Set<String> head = new TreeSet<>();
        Map<String,Map<String,Integer>> map = new TreeMap<>(Comparator.comparing(t->Integer.parseInt(t)));
        for (List<String> order : orders) {
            String tableNumber = order.get(1);
            String food = order.get(2);
            head.add(food);
            Map<String, Integer> foodMap = map.get(tableNumber);
            if(foodMap==null){
                foodMap = new TreeMap<>();
            }
            Integer foodNumber = foodMap.getOrDefault(food, 0);
            foodMap.put(food,foodNumber+1);
            map.put(tableNumber,foodMap);
        }
        LinkedList<String> header = new LinkedList<>(head);
        header.addFirst("Table");
        ans.add(header);
        map.entrySet().stream().sorted(Comparator.comparing(t->Integer.parseInt(t.getKey()))).forEach(entry->{
            String tableNumber = entry.getKey();
            List<String> list = new ArrayList<>();
            list.add(tableNumber);
            Map<String, Integer> foods = entry.getValue();
            for (int i = 1; i < header.size(); i++) {
                String foodName = header.get(i);
                list.add(String.valueOf(foods.getOrDefault(foodName,0)));
            }
            ans.add(list);
        });
        return ans;
    }

    volatile boolean  flag = false;

    @Test
    public void test(){
        /**
         *    核心线程数，最大线程数，闲置线程存活时间，时间单位，队列
         *    return new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         */
        ExecutorService service = Executors.newFixedThreadPool(2); //特性：固定线程数处理任务，使用的是无界阻塞队列，过多的任务会有内存溢出风险
        /**
         *   return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                                       60L, TimeUnit.SECONDS,
         *                                       new SynchronousQueue<Runnable>());
         */
        ExecutorService service1 = Executors.newCachedThreadPool();  //特性：可以持续创建线程，核心线程最大值为Integer.MAX，有栈溢出风险
        /**
         *  return new FinalizableDelegatedExecutorService
         *             (new ThreadPoolExecutor(1, 1,
         *                                     0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>()));
         */
        ExecutorService service2 = Executors.newSingleThreadExecutor();//特性:单一线程处理任务，使用的是无界阻塞队列，注意过多任务来不及处理导致的内存溢出风险

    }

    public static void main(String[] args) {
        /**
         *  super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
         *               new DelayedWorkQueue());
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);//
        long start = System.currentTimeMillis();
        System.out.println("time start:"+start);
        ScheduledFuture<?> schedule = scheduledExecutorService.schedule(() -> {
            System.out.println("5秒");
        }, 5, TimeUnit.SECONDS);
        while (!schedule.isDone()){
            //阻塞主线程，直到任务执行完成
        }

        long end = System.currentTimeMillis();
        System.out.println("执行完成:"+end);
        System.out.println("执行完成:"+(end-start)/1000);
        ReentrantLock lock  = new ReentrantLock();
        lock.lock();
    }
}
