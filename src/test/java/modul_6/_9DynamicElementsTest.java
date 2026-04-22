package modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _9DynamicElementsTest extends BaseTest {

    @Test
    void dynamicElementTest1() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/1");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));

        assertThat(text).not().isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();

        assertThat(text).isVisible();
    }

    @Test
    void dynamicElementTest2() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/2");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));

        assertThat(text).not().isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();

        assertThat(text).isVisible();
    }

    @Test
    void dynamicControlsTest1() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        Locator checkbox = page.locator("#checkbox");

        assertThat(checkbox).isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove")).click();

        assertThat(checkbox).not().isVisible();
        assertThat(page.getByText("It's gone!")).isVisible();
    }

    @Test
    void dynamicControlsTest2() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        Locator input = page.locator("#input-example input[type=text]");

        assertThat(input).isDisabled();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable")).click();

        assertThat(input).isEnabled();
        assertThat(page.getByText("It's enabled!")).isVisible();
    }
}
