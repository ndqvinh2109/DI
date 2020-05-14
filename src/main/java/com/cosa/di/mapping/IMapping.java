package com.cosa.di.mapping;

public interface IMapping {
    void configure();
    <T> Class<? extends T> getMapping(Class<T> type);
}
