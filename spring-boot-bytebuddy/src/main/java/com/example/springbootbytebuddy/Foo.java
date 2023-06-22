package com.example.springbootbytebuddy;

import org.springframework.stereotype.Service;

@Service
class Foo {

    String sayHello() throws Exception {
        System.out.println("in sayHello");
        Thread.sleep((long) (200 + (Math.random() * 100)));
        return "Hello World!";
    }

}
