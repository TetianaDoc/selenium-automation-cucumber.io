package com.junit.actions;

import com.junit.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public final class HomeAction extends BaseAction {
    private final HomePage homePage;

    public HomeAction() {
        super();
        homePage = new HomePage(getDriver());
    }

    public void getAllowAllCookiesButton() {
        List<WebElement> cookieButtons = findElements(homePage.getAllowCookiesLocator());
        if (!cookieButtons.isEmpty() && cookieButtons.get(0).isDisplayed()) {
            getWait().until(ExpectedConditions.elementToBeClickable(cookieButtons.get(0))).click();
        }
    }

    public void menuSection(String section) {
        By locator = homePage.getMenuSectionLocator(section);
        WebElement element = getWait().until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void menuChildItem(String item) {
        By locator = homePage.getMenuChildItemLocator(item);
        WebElement element = getWait().until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}
