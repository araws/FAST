package modul_7;

import common.BaseTest;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _4DialogTest extends BaseTest {

    @Test
    void dialogAlertTest() { //default OK button clicked
        page.navigate("http://the-internet.herokuapp.com/javascript_alerts");

        // Handler always before click
        page.onDialog(dialog -> {
            page.waitForTimeout(2000);
            dialog.accept();
        });

        page.getByText("Click for JS Alert").click();
        assertThat(page.locator("#result"))
                .hasText("You successfully clicked an alert");
    }

    @Test
    void dialogConfirmTest() { //default CANCEL button clicked
        page.navigate("http://the-internet.herokuapp.com/javascript_alerts");

        // Handler always before click
        page.onceDialog(dialog -> {
            page.waitForTimeout(2000);
            dialog.accept();
        });

        page.getByText("Click for JS Confirm").click();
        assertThat(page.locator("#result"))
                .hasText("You clicked: Ok");

        page.getByText("Click for JS Confirm").click();
        assertThat(page.locator("#result"))
                .hasText("You clicked: Cancel");
    }

    @Test
    void dialogPromptTest() { //default CANCEL button clicked
        page.navigate("http://the-internet.herokuapp.com/javascript_alerts");

        // Handler always before click
        page.onceDialog(dialog -> {
            page.waitForTimeout(2000);
            dialog.accept("123");
        });

        page.getByText("Click for JS Prompt").click();

        assertThat(page.locator("#result"))
                .hasText("You entered: 123");

        page.getByText("Click for JS Prompt").click();

        assertThat(page.locator("#result"))
                .hasText("You entered: null");
    }
}
