package com.cosa.di.inject;

import com.cosa.di.mapping.IMapping;
import com.cosa.di.enums.BeanScope;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class InjectHandling {

    private Map<Class<?>, Object> singletonInstanceMap = new HashMap<>();
    private IMapping mapping;

    public InjectHandling(IMapping mapping) {
        this.mapping = mapping;
    }

    public Object getInstance(Class klass) {
        Class subKlass = mapping.getMapping(klass);
        return singletonInstanceMap.get(subKlass);
    }

    public Object injectInstance(Class klass) throws Exception {

        if (klass != null) {

            for (Constructor constructor : klass.getConstructors()) {
                if (constructor.isAnnotationPresent(Inject.class)) {
                    Inject annotation = (Inject) constructor.getAnnotation(Inject.class);
                    BeanScope injectValue = annotation.value();

                    Class[] parameterTypes = constructor.getParameterTypes();
                    Object[] objArr = new Object[parameterTypes.length];

                    int i = 0;

                    for (Class c : parameterTypes) {
                        Class dependency = mapping.getMapping(c);

                        if (c.isAssignableFrom(dependency)) {
                            objArr[i] = dependency.getConstructor().newInstance();

                            if (injectValue == BeanScope.SINGLETON && singletonInstanceMap.containsKey(dependency)) {
                                objArr[i] = singletonInstanceMap.get(dependency);
                            }
                            singletonInstanceMap.put(dependency, objArr[i]);

                            i++;
                        }
                    }

                    Object resObj = klass.getConstructor(parameterTypes).newInstance(objArr);

                    return resObj;

                }
            }
        }

        return null;
    }

}
