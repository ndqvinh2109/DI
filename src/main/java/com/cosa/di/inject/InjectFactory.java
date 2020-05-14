package com.cosa.di.inject;

import com.cosa.di.core.IMapping;

public class InjectFactory {

    public static InjectHandling getInject(IMapping mapping) {
        mapping.configure();
        return new InjectHandling(mapping);
    }

}
