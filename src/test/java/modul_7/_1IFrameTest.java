package modul_7;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class _1IFrameTest extends BaseTest {

    @Test
    void should_enter_text_into_the_iframe() {
        page.navigate("https://the-internet.herokuapp.com/iframe");
        FrameLocator iFrame = page.frameLocator("#mce_0_ifr"); // if there is not a name of the frame
        page.pause();
        iFrame.locator("#tinymce").fill("DEMO");
    }

    @Test
    void should_getText_from_nested_frames() {
        page.navigate("https://the-internet.herokuapp.com/nested_frames");
        Frame frame = page.frame("frame-middle"); // if there is a name of the frame
        PlaywrightAssertions.assertThat(frame.locator("#content")).hasText("MIDDLE");
    }
}
