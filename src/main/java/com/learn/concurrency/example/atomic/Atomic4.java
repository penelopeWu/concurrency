package com.learn.concurrency.example.atomic;

import com.learn.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @ClassName Atomic4
 * @Description TODO
 * @Author penelope
 * @Date 2018-09-05 22:21
 * @Version 1.0
 **/
@Slf4j
@ThreadSafe
public class Atomic4 {

    private static AtomicIntegerFieldUpdater<Atomic4> updater = AtomicIntegerFieldUpdater.newUpdater(Atomic4.class, "count");
    @Getter
    private volatile int count = 100;

    public static void main(String[] args) {
        Atomic4 atomic4 = new Atomic4();
        if (updater.compareAndSet(atomic4, 100, 120)) {
            log.info("update success 1 : {}", atomic4.getCount());
        }

        if (updater.compareAndSet(atomic4, 100, 120)) {
            log.info("update success 1 : {}", atomic4.getCount());
        }else {
            log.info("update fail :{}",atomic4.getCount());
        }


    }
}
