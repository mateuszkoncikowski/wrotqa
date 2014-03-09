package org.wrotqa.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.wrotqa.page.Page;
import org.wrotqa.page.PrivacyPolicyPage;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 09:13
 */

public class Footer extends Page {

    @FindBy(xpath = "//a[contains(text(), 'Polityka')]")
    private WebElement privacyPolicyButton;

    public Footer(WebDriver driver) {
        super(driver);
    }

    public PrivacyPolicyPage openPrivacyPolicyPage() {
        clickElement(privacyPolicyButton);
        return PageFactory.initElements(getDriver(), PrivacyPolicyPage.class);
    }
}
