package com.cosa.di.core;

public interface IMapping {
    void configure();
    <T> Class<? extends T> getMapping(Class<T> type);
}
