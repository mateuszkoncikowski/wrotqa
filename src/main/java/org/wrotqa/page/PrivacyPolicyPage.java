package org.wrotqa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 09:19
 */

public class PrivacyPolicyPage extends Page {

    @FindBy(xpath = "//div[@class='staticContent']")
    private WebElement staticContent;

    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    public String getPageContent() {
        return getTextFromElement(staticContent);
    }
}
