package org.wrotqa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 08:13
 */

public class ClientRegistrationPage extends Page {

    @FindBy(name = "user_first_name")
    private WebElement firstNameField;

    @FindBy(name = "user_last_name")
    private WebElement lastNameField;

    public ClientRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillFirstNameField(String firstName) {
        typeInto(firstNameField, firstName);
    }

    public void fillLastNameField(String lastName) {
        typeInto(lastNameField, lastName);
    }
}
