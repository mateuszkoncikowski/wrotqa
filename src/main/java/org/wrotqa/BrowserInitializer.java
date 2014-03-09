package org.wrotqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.wrotqa.page.HomePage;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 07:31
 */

class BrowserInitializer {

    private WebDriver driver;

    public BrowserInitializer() {}

    public void startBrowser() {
        driver = new FirefoxDriver();
    }

    public HomePage openHomePage() {
        driver.get("http://testuj.pl/");
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void closeBrowser() {
        driver.close();
    }
}
