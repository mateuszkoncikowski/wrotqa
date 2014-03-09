package org.wrotqa.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.wrotqa.page.ContactPage;
import org.wrotqa.page.FaqPage;
import org.wrotqa.page.Page;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 09:02
 */

public class HeaderMenu extends Page {

    @FindBy(id = "buttonFaq")
    private WebElement faqButton;

    @FindBy(id = "buttonContact")
    private WebElement contactButton;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public FaqPage openFaqPage() {
        clickElement(faqButton);
        return PageFactory.initElements(getDriver(), FaqPage.class);
    }

    public ContactPage openContactPage() {
        clickElement(contactButton);
        return PageFactory.initElements(getDriver(), ContactPage.class);
    }
}
