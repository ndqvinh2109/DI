package com.cosa.di.core;

import com.cosa.di.service.FirstService;
import com.cosa.di.service.FirstServiceImpl;
import com.cosa.di.service.SecondService;
import com.cosa.di.service.SecondServiceImpl;

public class MappingTest extends AbstractMapping {

    @Override
    public void configure() {
        createMapping(FirstService.class, FirstServiceImpl.class);
        createMapping(SecondService.class, SecondServiceImpl.class);
    }

}
