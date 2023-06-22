package com.example.springbootbytebuddy;

import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;

public class LoggerInterceptor {
    public static String log(@SuperCall Callable<String> zuper) throws Exception {
        var start = System.currentTimeMillis();
        System.out.println("[in agent] invoking original method ....");
        try {
            return zuper.call();
        } catch (Exception e) {
            System.err.println("[in agent] should never happen");
            throw new RuntimeException(e);
        } finally {
            var end = System.currentTimeMillis();
            System.out.println("[in agent] Returned, took " + (end - start) + "ms");
        }
    }
}
