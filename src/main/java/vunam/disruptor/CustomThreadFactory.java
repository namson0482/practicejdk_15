package vunam.disruptor;

import java.util.concurrent.ThreadFactory;
import java.io.*;

class CustomThreadFactory implements ThreadFactory {

    // newThread is a factory method
    // provided by ThreadFactory
    public Thread newThread(Runnable command) {
        return new Thread(command);
    }
}
