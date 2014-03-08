package org.wrotqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.wrotqa.page.HomePage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * User: Mateusz Koncikowski
 * Date: 08/03/14
 * Time: 07:21
 */

public class PageObjectPatternTests {

    private HomePage homePage;
    private BrowserInitializer initializer;

    @Before
    public void initializeBrowser() {
        initializer = new BrowserInitializer();
        initializer.startBrowser();
        homePage = initializer.openHomePage();
    }

    @Test
    public void getInfoAboutTestujOrg() {
        String expectedInfo = "Testuj.pl to pierwsza w Polsce testerska platforma ";

        String pageInfo = homePage.getPageInfo();

        assertThat(pageInfo, containsString(expectedInfo));
    }

    @After
    public void closeBrowser() {
        initializer.closeBrowser();
    }
}
