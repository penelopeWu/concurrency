package com.learn.concurrency.example.immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ImmutableExample2
 * @Description TODO
 * @Author penelope
 * @Date 2018-09-05 23:59
 * @Version 1.0
 **/
public class ImmutableExample2 {
    private static Map<Integer,Integer> map  = new HashMap<>();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }
    public static void main(String[] args) {
        map.put(7, 8);
        map = new HashMap<>();
    }
}
