package org.wrotqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.wrotqa.page.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

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
    public void task_1() {
        /**
         * Scenario:
         * 1) Open home page
         * 2) Get info about the portal
         *
         * Xpath:
         * //div[@class='mainInfo']
        **/

        String pageInfo = homePage.getInfoAboutPortal();

        String expectedPageInfo = "Testuj.pl to pierwsza w Polsce testerska platforma";
        assertThat(pageInfo, containsString(expectedPageInfo));
    }

    @Test
    public void task_2() {
        /**
         * Scenario:
         * 1) Open home page
         * 2) Try to login into the portal using bad credentials
         *
         * Name:
         * username
         * passwordField
         *
         * Xpath:
         * //input[@type = 'submit']
         **/

        PostLoginPage postLoginPage = homePage.getHeader().login("User", "WrongPassword");
        String postLoginPageSource = postLoginPage.getPageSource();

        String expectedErrorMessage = "Podałeś błędny e-mail lub hasło";
        assertThat(postLoginPageSource, containsString(expectedErrorMessage));
    }

    @Test
    public void task_3() {
        /**
         * Scenario:
         * 1) Open home page
         * 2) Go to privacy policy page via footer
         * 3) Get static page content
         *
         * Id:
         * buttonFaq
         *
         * Xpath:
         * //a[contains(text(), 'Polityka')]
         * //div[@class='staticContent']
         **/

        FaqPage faqPage = homePage.getHeaderMenu().openFaqPage();
        PrivacyPolicyPage privacyPolicyPage = faqPage.getFooter().openPrivacyPolicyPage();
        String pageContent = privacyPolicyPage.getPageContent();

        String expectedPageContent = "Niniejsza Polityka Prywatności informuje o sposobach ochrony";
        assertThat(pageContent, containsString(expectedPageContent));
    }

    @Test
    public void task_4() {
        /**
         * Scenario:
         * 1) Open home page
         * 2) Accept cookies
         *
         * Id:
         * accept-cookies-checkbox
         **/

        homePage.getAcceptCookiesPanel().acceptCookies();
        String pageSource = homePage.getPageSource();

        String cookiePanelMessage = "Ta strona używa ciasteczek (cookies)";
        assertThat(pageSource, not(containsString(cookiePanelMessage)));

    }

    @Test
    public void task_5() {
        /**
         * Scenario:
         * 1) Open home page
         * 2) Open contact page
         * 3) Open privacy policy page via cookie panel
         *
         * Id:
         * buttonContact
         *
         * Xpath:
         * //a[contains(text(), 'Dowiedz się więcej')]
         * //div[@class='staticContent']
         **/

        ContactPage contactPage = homePage.getHeaderMenu().openContactPage();
        PrivacyPolicyPage privacyPolicyPage = contactPage.getAcceptCookiesPanel().openPrivacyPolicyPage();
        String pageContent = privacyPolicyPage.getPageContent();

        String expectedPageContent = "Niniejsza Polityka Prywatności informuje o sposobach ochrony";
        assertThat(pageContent, containsString(expectedPageContent));
    }

    @After
    public void closeBrowser() {
        initializer.closeBrowser();
    }
}
