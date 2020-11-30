package com.devex.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/test")
public class TestController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String test(){
        return "Hello World";
    }
}
