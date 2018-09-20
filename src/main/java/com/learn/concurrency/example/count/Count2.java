package com.learn.concurrency.example.count;

import com.learn.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName ConcurrencyTest
 * @Description TODO
 * @Author penelope
 * @Date 2018-09-05 21:44
 * @Version 1.0
 **/
@Slf4j
@ThreadSafe
public class Count2 {
    private static int clientNum = 10000;
    private static int threadNum = 200;
    private static int count = 0;
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadNum);
        final CountDownLatch countDownLatch = new CountDownLatch(clientNum);
        for (int i = 0; i < clientNum; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
        log.info("time:{}",System.currentTimeMillis()-start);
    }

    private  synchronized static void add() {
        count++;
    }
}
