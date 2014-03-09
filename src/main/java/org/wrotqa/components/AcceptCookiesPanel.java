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
 * Time: 09:42
 */

public class AcceptCookiesPanel extends Page {

    @FindBy(id = "accept-cookies-checkbox")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//a[contains(text(), 'Dowiedz się więcej')]")
    private WebElement privacyPolicyLink;

    public AcceptCookiesPanel(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        clickElement(acceptCookiesButton);
    }

    public PrivacyPolicyPage openPrivacyPolicyPage() {
        clickElement(privacyPolicyLink);
        return PageFactory.initElements(getDriver(), PrivacyPolicyPage.class);
    }
}
