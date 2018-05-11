package com.lemzki.trvansched.webservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWebService {
    @Value("${test.active.prof}")
    private String testProperty;

    @GetMapping("/test")
    public String test() {
    	return "TEST PROPERTY " + testProperty;
    }
    
    
    
}
