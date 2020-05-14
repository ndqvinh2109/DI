package com.cosa.di.mapping;

import com.cosa.di.service.FirstService;
import com.cosa.di.service.SecondService;
import com.cosa.di.service.SecondServiceImpl;
import com.cosa.di.service.FirstServiceImpl;

public class Mapping extends AbstractMapping {

    public void configure() {
        createMapping(FirstService.class, FirstServiceImpl.class);
        createMapping(SecondService.class, SecondServiceImpl.class);
    }

}
