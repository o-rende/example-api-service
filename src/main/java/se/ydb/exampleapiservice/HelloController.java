package se.ydb.exampleapiservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

@RestController
public class HelloController {

    private ExampleApiServiceConfiguration config;

    public HelloController(ExampleApiServiceConfiguration config) {
        this.config = config;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Greetings from " + defaultIfNull(config.name, "Spring Boot!");
    }
}