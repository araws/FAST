package modul_4;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import common.BaseTest;
import org.junit.jupiter.api.Test;

class LoginWithValidCredentialsTest extends BaseTest {

    @Test
    void should_login_with_valid_credentials() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.fill("#username", "tomsmith");
        page.fill("#password", "SuperSecretPassword!");
        page.click("#login button");

        PlaywrightAssertions.assertThat(page.locator("text=You logged into a secure area!")).isVisible();

        page.click("//i[contains(text(), 'Logout')]");

        PlaywrightAssertions.assertThat(page.locator("text=You logged out of the secure area!")).isVisible();
    }
}
