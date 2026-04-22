package modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class _7RadioButtonTest extends BaseTest {

    @Test
    void radioButtonTest() {
        page.navigate("https://testpages.eviltester.com/pages/forms/html-form/");

        Locator radio1 = page.locator("input[value=rd1]");
        Locator radio2 = page.locator("input[value=rd2]");

        PlaywrightAssertions.assertThat(radio1).not().isChecked();
        PlaywrightAssertions.assertThat(radio2).isChecked();

        radio1.check();

        PlaywrightAssertions.assertThat(radio1).isChecked();
        PlaywrightAssertions.assertThat(radio2).not().isChecked();
    }
}
