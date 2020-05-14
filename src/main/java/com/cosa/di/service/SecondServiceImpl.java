package com.cosa.di.service;

public class SecondServiceImpl implements SecondService {
    @Override
    public void doSomething() {
        System.out.println("Do something in SecondServiceImpl " + this);
    }
}
