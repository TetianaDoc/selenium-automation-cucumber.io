package com.junit.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        monochrome = true,
        tags = "@smoke",
        glue = "com.junit",
        features = "classpath:com/junit/features"
)
public class TestRunner {
}
