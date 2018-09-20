package com.learn.concurrency.example.atomic;

import com.learn.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName ConcurrencyTest
 * @Description TODO
 * @Author penelope
 * @Date 2018-09-05 21:44
 * @Version 1.0
 **/
@Slf4j
@NotThreadSafe
public class Atomic3 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 1);
        count.compareAndSet(0, 2);
        count.compareAndSet(1, 3);
        count.compareAndSet(2, 4);
        count.compareAndSet(3, 5);
        log.info("count:{}",count);
    }
}
