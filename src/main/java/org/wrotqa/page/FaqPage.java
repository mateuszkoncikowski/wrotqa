package org.wrotqa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.wrotqa.components.Footer;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 09:12
 */

public class FaqPage extends Page {

    private final Footer footer;

    public FaqPage(WebDriver driver) {
        super(driver);
        footer = PageFactory.initElements(getDriver(), Footer.class);
    }

    public Footer getFooter() {
        return footer;
    }
}
