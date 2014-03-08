package org.wrotqa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 07:23
 */

public class Page {

    public final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getElementText(By by) {
        return getDriver().findElement(by).getText();
    }

    public String getElementTextByXpath(String xpath) {
        return getElementText(By.xpath(xpath));
    }
}
