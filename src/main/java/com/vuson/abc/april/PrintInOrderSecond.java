package com.vuson.abc.april;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
class ObjectA implements Runnable {

    String value;

    public ObjectA(String value) {
        this.value = value;
    }

    @Override
    public void run() {
        log.info(value);
    }
}

@Slf4j
public class PrintInOrderSecond {
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public PrintInOrderSecond() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.incrementAndGet();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {

        }
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {

        }
        printThird.run();
    }

    public static void main(String[] args) {
        Runnable printFirst = new ObjectA("printFirst");
        Runnable printSecond = new ObjectA("printSecond");
        Runnable printThird = new ObjectA("printThird");

        PrintInOrderSecond printInOrderSecond = new PrintInOrderSecond();
        try {
            printInOrderSecond.first(printFirst);
            printInOrderSecond.second(printSecond);
            printInOrderSecond.third(printThird);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
