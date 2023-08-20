package com.vuson.abc.april;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintInOrder {

    private boolean oneDone;
    private boolean twoDone;

    public PrintInOrder() {
        oneDone = true;
        twoDone = true;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        oneDone = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (!oneDone) {
            wait();
        }
        printSecond.run();
        twoDone = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (!twoDone) {
            wait();
        }
        printThird.run();
    }

}
