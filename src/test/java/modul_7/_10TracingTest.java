package modul_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class _10TracingTest extends BaseTest {

    // Terminal mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args=”show-trace traces/trace.zip”

    @Test
    void traceDemoTest() {
        page.navigate("https://the-internet.herokuapp.com/");
        page.getByText("Form Authentication").click();
        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("Password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
