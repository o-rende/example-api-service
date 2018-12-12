package se.ydb.exampleapiservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "greetings")
public class ExampleApiServiceConfiguration {

    @JsonProperty("name")
    public String name;

    public void setName(String name) {
        this.name = name;
    }
}
