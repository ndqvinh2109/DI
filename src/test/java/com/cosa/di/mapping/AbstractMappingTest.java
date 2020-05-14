package com.cosa.di.mapping;

import com.cosa.di.service.FirstService;
import com.cosa.di.service.FirstServiceImpl;
import com.cosa.di.service.SecondService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbstractMappingTest {

    private MappingTest mappingTest;

    @BeforeEach
    public void init() {
        mappingTest = new MappingTest();
        mappingTest.configure();
    }

    @Test
    public void should_MappingSubClassToSuperClass() {
        Class<?> clazz = mappingTest.getMapping(FirstService.class);
        Assertions.assertTrue(clazz.isInstance(new FirstServiceImpl()));
    }

    @Test
    public void shouldThrowExceptionForUnconfiguredClass() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> mappingTest.getMapping(SecondService.class));
    }

}
