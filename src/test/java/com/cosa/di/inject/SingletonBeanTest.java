package com.cosa.di.inject;

import com.cosa.di.client.Singleton;
import com.cosa.di.mapping.MappingTest;
import com.cosa.di.service.FirstService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SingletonBeanTest {

    private MappingTest mappingTest;
    private InjectHandling injectHandling;

    @BeforeEach
    public void init() {
        mappingTest = new MappingTest();
        mappingTest.configure();
        injectHandling = new InjectHandling(mappingTest);
    }

    @Test
    public void should_getSameInstanceForSingletonBean() throws Exception {
        injectHandling.injectInstance(Singleton.class);
        Object obj1 = injectHandling.getInstance(FirstService.class);

        injectHandling.injectInstance(Singleton.class);
        Object obj2 = injectHandling.getInstance(FirstService.class);

        Assertions.assertEquals(obj1, obj2);
    }


}
