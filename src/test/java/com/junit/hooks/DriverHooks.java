package com.junit.hooks;

import com.junit.driver.DriverManager;
import io.cucumber.java.After;

public class DriverHooks {
    @After(order = 0)
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
