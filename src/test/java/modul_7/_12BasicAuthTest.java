package modul_7;

import common.BaseTest;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class _12BasicAuthTest extends BaseTest {

    @Test
    void basicAuthTest() {
        page.navigate("https://the-internet.herokuapp.com/basic_auth");

        assertThat(page.getByText("Congratulations! You must have the proper credentials.")).isVisible();
    }
}
