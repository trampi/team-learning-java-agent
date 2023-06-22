package com.example.springbootbytebuddy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FooController {

    FooController(Foo foo) {
        this.foo = foo;
    }

    private Foo foo;

    @ResponseBody
    @GetMapping("/")
    public String index() throws Exception {
        return foo.sayHello();
    }

}
