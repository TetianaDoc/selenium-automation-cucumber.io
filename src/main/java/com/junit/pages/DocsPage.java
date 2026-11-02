package com.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class DocsPage extends BasePage {
    private static final String PAGE_TITLE_PATTERN = "//h1[contains(normalize-space(), '%s')]";

    public DocsPage(WebDriver driver) {
        super(driver);
    }

    public By getPageTitleLocator(String pageTitle) {
        return By.xpath(format(PAGE_TITLE_PATTERN, pageTitle));
    }
}
