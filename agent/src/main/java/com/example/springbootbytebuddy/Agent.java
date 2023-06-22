package com.example.springbootbytebuddy;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Agent {

    public static void premain(String arguments, Instrumentation instrumentation) {
        System.out.println("loading agent");

        /*
        new AgentBuilder.Default()
                .type(named("com.example.springbootbytebuddy.Foo"))
                .transform((builder, typeDescription, classloader, javaModule, protectionDomain) ->
                        builder.method(named("sayHello"))
                                .intercept(FixedValue.value("this is magic, coming from the agent")))
                .installOn(instrumentation);
         */

        new AgentBuilder.Default()
                // .with(AgentBuilder.Listener.StreamWriting.toSystemOut())
                .type(named("com.example.springbootbytebuddy.Foo"))
                .transform((builder, typeDescription, classloader, javaModule, protectionDomain) ->
                        builder.method(named("sayHello"))
                                .intercept(MethodDelegation.to(LoggerInterceptor.class)))
                .installOn(instrumentation);
    }

}
