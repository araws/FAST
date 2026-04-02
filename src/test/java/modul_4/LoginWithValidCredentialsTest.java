package modul_4;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import common.BaseTest;
import org.junit.jupiter.api.Test;

class LoginWithValidCredentialsTest extends BaseTest {

    @Test
    void should_login_with_valid_credentials() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.fill("#username", "tomsmith");
        page.fill("#password", "SuperSecretPassword!");
        Locator button = page.locator("text=Login").last();
        button.click();

        PlaywrightAssertions.assertThat(page.locator("text=You logged into a secure area!")).isVisible();
    }
}
