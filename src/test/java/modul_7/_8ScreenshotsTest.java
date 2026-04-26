package modul_7;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class _8ScreenshotsTest extends BaseTest {

    @Test
    void screenshotPageTest() {
        page.navigate("http://the-internet.herokuapp.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/home.jpeg")));
    }

    @Test
    void screenshotElementTest() {
        page.navigate("http://the-internet.herokuapp.com/login");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        page.locator("#flash-messages")
                .screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/element.jpeg")));
    }
}
