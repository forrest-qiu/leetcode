package designPattern;

public class DeadLock {

    public static String lock1 = "lock1";
    public static String lock2 = "lock2";

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

}


class Thread1 extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (DeadLock.lock1) {
                    System.out.println("thread1锁住了lock1");
                    Thread.sleep(3000);
                    synchronized (DeadLock.lock2) {
                        System.out.println("thread1锁住了lock2");
                        Thread.sleep(200);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Thread2 extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (DeadLock.lock2) {
                    System.out.println("thread2锁住了lock2");
                    Thread.sleep(3000);
                    synchronized (DeadLock.lock1) {
                        System.out.println("thread2锁住了lock1");
                        Thread.sleep(200);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

