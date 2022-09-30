package producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    private Queue<E> queue;
    private int max = 16;
    //private ReentrantLock lock = new ReentrantLock(true);
    private Object notEmpty = new Object();
    private Object notFull = new Object();



    public MyBlockingQueue(int size){
        queue = new LinkedList<>();
        this.max = size;
    }

    public synchronized void put(E e) throws InterruptedException{
            while(queue.size() == max){
                notFull.wait();
            }
            queue.offer(e);
            notEmpty.notifyAll();

    }

    public synchronized E take() throws InterruptedException{
         while(queue.size() == 0){
             notEmpty.wait();
         }
            E item = queue.poll();
            notFull.notifyAll();
            return item;
    }

    public static void main(String[] args) {

    }
}
