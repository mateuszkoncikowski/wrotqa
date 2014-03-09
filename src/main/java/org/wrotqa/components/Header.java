package org.wrotqa.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.wrotqa.page.Page;
import org.wrotqa.page.PostLoginPage;

/**
 * User: Mateusz Koncikowski
 * Date: 09/03/14
 * Time: 19:43
 */

public class Header extends Page {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement submitButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public PostLoginPage login(String login, String password) {
        typeInto(usernameField, login);
        typeInto(passwordField, password);
        clickElement(submitButton);
        return PageFactory.initElements(getDriver(), PostLoginPage.class);
    }
}
