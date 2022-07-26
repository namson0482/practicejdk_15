package vunam.disruptor;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Rohit Sachan on 1/13/14.
 */
public class Consumer implements Runnable{

    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;
            long startTime = System.nanoTime();
            System.out.println();
            //consuming messages until exit message is received
            while((msg = queue.take()).getMsg() !=-1){
                Integer msgStr = msg.getMsg();
                if(msgStr % 10000 == 0)
                    System.out.println("Consumed "+msgStr);
            }
            double timeINnanos = (System.nanoTime()-startTime);
            System.out.println(timeINnanos + " taken in Nanos");
            double timetaken = (timeINnanos/1e9);

            NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            DecimalFormat df = (DecimalFormat)nf;

            System.out.printf("Total time taken in consuming %d, messages %n", Producer.maxMsg * Producer.multiply);

            System.out.println("Speed = "+df.format(Producer.maxMsg* Producer.multiply/timetaken) + " msgs per sec");
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
