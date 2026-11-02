package com.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;

public class HomePage extends BasePage {
    private static final String MENU_SECTION_XPATH = "//a[contains(@class, 'navbar__link') and normalize-space()='%s']";
    private static final String CHILD_MENU_ITEM_XPATH = "//a[contains(@class, 'menu__link') and normalize-space()='%s']";
    private static final String ALLOW_COOKIES_XPATH = "//button[contains(text(), 'Allow all cookies') or contains(@class, 'ch2-allow-all-btn')]";

    @FindBy(xpath = ALLOW_COOKIES_XPATH)
    private WebElement allowAllCookiesButton;

    @FindBy(xpath = "//a[contains(@class, 'navbar__link') and normalize-space()='Documentation']")
    private WebElement docsMenu;

    @FindBy(css = "a.menu__link[href='/docs/gherkin/']")
    private WebElement gherkinSyntaxItem;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By getAllowCookiesLocator() {
        return By.xpath(ALLOW_COOKIES_XPATH);
    }

    public By getMenuSectionLocator(String sectionName) {
        return By.xpath(format(MENU_SECTION_XPATH, sectionName));
    }

    public By getMenuChildItemLocator(String itemName) {
        return By.xpath(format(CHILD_MENU_ITEM_XPATH, itemName));
    }

    public WebElement getGherkinSyntaxItem() {
        return gherkinSyntaxItem;
    }

    public void setGherkinSyntaxItem(WebElement gherkinSyntaxItem) {
        this.gherkinSyntaxItem = gherkinSyntaxItem;
    }

    public WebElement getAllowAllCookiesButton() {
        return allowAllCookiesButton;
    }

    public void setAllowAllCookiesButton(WebElement allowAllCookiesButton) {
        this.allowAllCookiesButton = allowAllCookiesButton;
    }

    public WebElement getDocsMenu() {
        return docsMenu;
    }

    public void setDocsMenu(WebElement docsMenu) {
        this.docsMenu = docsMenu;
    }
}
