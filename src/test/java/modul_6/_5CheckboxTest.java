package modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class _5CheckboxTest extends BaseTest {

    @Test
    void checkboxTest() {
        page.navigate("https://the-internet.herokuapp.com/checkboxes");

        Locator firstCheckbox = page.getByRole(AriaRole.CHECKBOX).first();
        Locator lastCheckbox = page.getByRole(AriaRole.CHECKBOX).last();

        PlaywrightAssertions.assertThat(firstCheckbox).not().isChecked();

        firstCheckbox.check();

        PlaywrightAssertions.assertThat(firstCheckbox).isChecked();

        PlaywrightAssertions.assertThat(lastCheckbox).isChecked();

        lastCheckbox.uncheck();

        PlaywrightAssertions.assertThat(lastCheckbox).not().isChecked();
    }
}
