package designPattern;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用object.wait object.notify实现队列消费
 */
public class MessageQueue {
    
    public static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
            new Produce().start();
            new Consumer().start();
    }
}


class Produce extends Thread {
    @Override
    public void run() {
        while (true){
            synchronized (MessageQueue.queue){
                if(MessageQueue.queue.size()>=10){
                    try {
                        MessageQueue.queue.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                MessageQueue.queue.offer("apple");
                System.out.println("生产了一个消息，目前已经有"+MessageQueue.queue.size()+"个消息");
                MessageQueue.queue.notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Consumer extends Thread {
    @Override
    public void run() {
        while (true){
            synchronized (MessageQueue.queue){
                if(MessageQueue.queue.size()==0){
                    try {
                        MessageQueue.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                MessageQueue.queue.poll();
                System.out.println("消费了一个消息，目前剩余消息："+MessageQueue.queue.size()+"个");
                MessageQueue.queue.notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
