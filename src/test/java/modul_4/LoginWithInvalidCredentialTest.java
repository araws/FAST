package modul_4;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

class LoginWithInvalidCredentialTest extends BaseTest {

    @Test
    void should_fail_with_no_credentials() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
    }

    @Test
    void should_fail_with_wrong_password() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("Password").fill("SuperSecretPassword");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        PlaywrightAssertions.assertThat(page.getByText("Your password is invalid!")).isVisible();
    }

    @Test
    void should_fail_with_wrong_username() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("Username").fill("tomsmith1");
        page.getByLabel("Password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
    }
}
