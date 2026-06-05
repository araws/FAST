package modul_8;

import common.BaseTest;
import modul_8.dto.ContactUsDTO;
import modul_8.pages.ContactUsPage;
import modul_8.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SendContactUsFormTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate("http://automationpractice.co.pl");
    }

    @Test
    void should_show_an_error_when_trying_to_send_empty_form_test() {
        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickAtContactUsLink();
        contactUsPage.getContactUsFormSection().clickOnSendMessageButton();

        assertThat(contactUsPage.getContactUsFormSection().getErrorMessage()).isVisible();
    }

    @Test
    void should_fill_and_send_contact_us_form_test() {
        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickAtContactUsLink();
        contactUsPage.getContactUsFormSection().sentContactUsForm(ContactUsDTO.getDefaultContactUsDTO());

        assertThat(contactUsPage.getContactUsFormSection().getConfirmationMessage()).isVisible();
    }
}
