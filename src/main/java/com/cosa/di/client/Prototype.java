package com.cosa.di.client;

import com.cosa.di.enums.BeanScope;
import com.cosa.di.inject.Inject;
import com.cosa.di.service.SecondService;

public class Prototype {

    private SecondService secondService;

    @Inject(value = BeanScope.PROTOTYPE)
    public Prototype(SecondService secondService) {
        this.secondService = secondService;
    }

    public void doSomething() {
        secondService.doSomething();
    }
}
