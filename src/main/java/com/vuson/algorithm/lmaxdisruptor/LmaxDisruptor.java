package com.vuson.algorithm.lmaxdisruptor;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Rohit Sachan on 1/13/14.
 */
public class LmaxDisruptor {

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
//        BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>(10000000);
//        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);
//        //starting producer to produce messages in queue
//        new Thread(producer).start();
//        //starting consumer to consume messages from queue
//        new Thread(consumer).start();
//        System.out.println("Producer and Consumer has been started");

        ExecutorService exec = Executors.newCachedThreadPool();
        // Preallocate RingBuffer with 1024 ValueEvents
        Disruptor<Message> disruptor = new Disruptor<Message>(Message.EVENT_FACTORY, 2048, exec,
                ProducerType.SINGLE, new BusySpinWaitStrategy());

        // make handler
        final  long startTime = System.nanoTime();
        final EventHandler<Message> handler = new EventHandler<Message>() {
            // event will eventually be recycled by the Disruptor after it wraps
            public void onEvent(final Message event, final long sequence, final boolean endOfBatch) throws Exception {
                Integer value = event.getMsg();
                if(value % 10000 == 0){
                    System.out.println("By Handler : ValueEvent: " + value + " Sequence: " + sequence);
                    double timeINnanos = (System.nanoTime()-startTime);
                    double timetaken = (timeINnanos/1e9);
                    System.out.println("Time Taken till now in sec " + timetaken );
                }
            }
        };
        final EventHandler<Message> handler2 = new EventHandler<Message>() {
            // event will eventually be recycled by the Disruptor after it wraps
            public void onEvent(final Message event, final long sequence, final boolean endOfBatch) throws Exception {
                Integer value = event.getMsg();
                if(value % 10000 == 0){
                    System.out.println("By Handler2 :ValueEvent: " + value + " Sequence: " + sequence);
                    double timeINnanos = (System.nanoTime()-startTime);
                    double timetaken = (timeINnanos/1e9);
                    System.out.println("Time Taken till now in sec " + timetaken );
                }
            }
        };
        // register handler with disruptor
        disruptor.handleEventsWith(handler,handler2);

        RingBuffer<Message> ringBuffer = disruptor.start();

        Producer producerOne = new Producer(ringBuffer);
        Producer producerTwo = new Producer(ringBuffer);

        //starting producer to produce messages in queue
        Thread pOne = new Thread(producerOne);
        pOne.start();

        Thread pTwo = new Thread(producerTwo);
        pTwo.start();
        try {
            pOne.join();
            pTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
