package modul_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class _10TracingTest extends BaseTest {

    @Test
    void traceDemoTest() {
        page.navigate("https://the-internet.herokuapp.com/");
        page.getByText("Form Authentication").click();
        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("Password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
