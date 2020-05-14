package com.cosa.di.core;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMapping implements IMapping {

    private Map<Class<?>, Class<?>> classMap = new HashMap<Class<?>, Class<?>>();

    <T> void createMapping(Class<T> baseClass, Class<? extends T> subClass) {
        classMap.put(baseClass, subClass.asSubclass(baseClass));
    }

    public <T> Class<? extends T> getMapping(Class<T> type) {
        Class<?> implementation = classMap.get(type);

        if (implementation == null)
            throw new IllegalArgumentException("Couldn't find the mapping for : " + type);

        return implementation.asSubclass(type);
    }
}
