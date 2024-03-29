package com.vuson.algorithm.lmaxdisruptor;

import com.lmax.disruptor.RingBuffer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Rohit Sachan on 1/13/14.
 */
public class Producer implements Runnable {

    static public Integer maxMsg =  1000000;
    static public int multiply = 10;
    private RingBuffer<Message> rb;


    private BlockingQueue<Message> queue;


    public Producer(BlockingQueue<Message> q){
        this.queue=q;
    }

    public Producer(RingBuffer rb){
        this.rb=rb;
    }
    @Override
    public void run() {
        for (int i =0; i < maxMsg * multiply ; i++){
            long seq = rb.next();
            Message msg= rb.get(seq);
            msg.setMsg(i);
            rb.publish(seq);
        }
        System.out.println("done sending " + maxMsg*multiply + " messages");
    }

}
