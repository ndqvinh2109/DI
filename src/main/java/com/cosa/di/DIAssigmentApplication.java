package com.cosa.di;

import com.cosa.di.client.Singleton;
import com.cosa.di.client.Prototype;
import com.cosa.di.mapping.Mapping;
import com.cosa.di.inject.InjectFactory;
import com.cosa.di.inject.InjectHandling;


public class DIAssigmentApplication {

    public static void main(String[] args) throws Exception {
        InjectHandling injectHandling = InjectFactory.getInject(new Mapping());

        Singleton singleton = (Singleton) injectHandling.injectInstance(Singleton.class);
        singleton.printSomething();

        Prototype prototype = (Prototype) injectHandling.injectInstance(Prototype.class);
        prototype.doSomething();

    }
}
