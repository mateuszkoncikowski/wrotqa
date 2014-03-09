package org.wrotqa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.wrotqa.components.AcceptCookiesPanel;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 09:50
 */

public class ContactPage extends Page {

    private final AcceptCookiesPanel acceptCookiesPanel;

    public ContactPage(WebDriver driver) {
        super(driver);
        acceptCookiesPanel = PageFactory.initElements(getDriver(), AcceptCookiesPanel.class);
    }

    public AcceptCookiesPanel getAcceptCookiesPanel() {
        return acceptCookiesPanel;
    }
}
