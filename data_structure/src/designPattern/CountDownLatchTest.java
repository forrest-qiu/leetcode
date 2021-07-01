package designPattern;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new CountDownThread(latch).start();
        }
        latch.await();//等待上面所有线程执行完成
        System.out.println("开始执行主线程任务");
    }
}

class CountDownThread extends Thread {

    private CountDownLatch latch;

    public CountDownThread(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}

