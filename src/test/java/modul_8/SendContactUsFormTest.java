package modul_8;

import common.BaseTest;
import modul_8.pages.ContactUsPage;
import modul_8.pages.HomePage;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SendContactUsFormTest extends BaseTest {

    @Test
    void should_show_an_error_when_trying_to_send_empty_form_test() {
        page.navigate("http://automationpractice.co.pl");

        HomePage homePage = new HomePage(page);
        ContactUsPage contactUsPage = new ContactUsPage(page);

        homePage.clickAtContactUsLink();
        contactUsPage.clickAtSendButton();

        assertThat(contactUsPage.getErrorMessage()).isVisible();
    }
}
