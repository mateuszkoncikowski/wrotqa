package org.wrotqa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 07:23
 */

public class Page {

    private final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPageSource() {
        return getDriver().getPageSource();
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void typeInto(WebElement element, String value) {
        element.sendKeys(value);
    }

}
