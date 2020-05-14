package com.cosa.di.inject;

import com.cosa.di.client.Prototype;
import com.cosa.di.mapping.MappingTest;
import com.cosa.di.service.SecondService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrototypeBeanTest {
    private MappingTest mappingTest;
    private InjectHandling injectHandling;

    @BeforeEach
    public void init() {
        mappingTest = new MappingTest();
        mappingTest.configure();
        injectHandling = new InjectHandling(mappingTest);
    }

    @Test
    public void should_getDifferentInstanceForPrototypeBean() throws Exception {
        injectHandling.injectInstance(Prototype.class);
        Object obj1 = injectHandling.getInstance(SecondService.class);

        injectHandling.injectInstance(Prototype.class);
        Object obj2 = injectHandling.getInstance(SecondService.class);

        Assertions.assertNotEquals(obj1, obj2);
    }
}
