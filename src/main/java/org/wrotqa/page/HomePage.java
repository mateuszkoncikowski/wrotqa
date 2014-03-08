package org.wrotqa.page;

import org.openqa.selenium.WebDriver;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 07:41
 */

public class HomePage extends Page{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getPageInfo() {
        return getElementTextByXpath("//div[@class='mainInfo']");
    }
}
