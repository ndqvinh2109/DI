package com.cosa.di.client;

import com.cosa.di.enums.BeanScope;
import com.cosa.di.inject.Inject;
import com.cosa.di.service.FirstService;

public class Singleton {

    private FirstService firstService;

    @Inject(value = BeanScope.SINGLETON)
    public Singleton(FirstService firstService) {
        this.firstService = firstService;
    }

    public void printSomething() {
        firstService.printSomething();
    }

}
