package org.wrotqa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.wrotqa.components.AcceptCookiesPanel;
import org.wrotqa.components.Header;
import org.wrotqa.components.HeaderMenu;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 07:41
 */

public class HomePage extends Page {

    private final Header header;
    private final HeaderMenu headerMenu;
    private final AcceptCookiesPanel acceptCookiesPanel;

    @FindBy(xpath = "(//a[contains(text(), 'Zarejestruj się')])[2]")
    private WebElement clientRegisterButton;

    @FindBy(xpath = "//div[@class='mainInfo']")
    private WebElement portalInfo;

    public HomePage(WebDriver driver) {
        super(driver);
        headerMenu = PageFactory.initElements(getDriver(), HeaderMenu.class);
        header = PageFactory.initElements(getDriver(), Header.class);
        acceptCookiesPanel = PageFactory.initElements(getDriver(), AcceptCookiesPanel.class);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public AcceptCookiesPanel getAcceptCookiesPanel() {
        return acceptCookiesPanel;
    }

    public Header getHeader() {
        return header;
    }

    public String getInfoAboutPortal() {
        return getTextFromElement(portalInfo);
    }
}
