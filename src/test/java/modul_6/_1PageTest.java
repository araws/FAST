package modul_6;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitUntilState;
import common.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _1PageTest extends BaseTest {

    @Test
    void page_test() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.navigate("https://the-internet.herokuapp.com/login", new Page.NavigateOptions().setTimeout(10000)); // default is 30000 ms
        page.navigate("https://the-internet.herokuapp.com/login", new Page.NavigateOptions().
                setWaitUntil(WaitUntilState.LOAD));

//      1. DOMCONTENTLOAD - HTML is loaded, but CSS and js not yet
//      2. LOAD - HTML, CSS and js are loaded (DEFAULT)
//      3. NETWORKIDLE - state in which there is no more requests by 500 ms

        page.navigate("https://the-internet.herokuapp.com/login", new Page.NavigateOptions()
                .setReferer("https://google.com"));

        page.reload();
        page.goBack();
        page.goForward();

        page.click("", new Page.ClickOptions().setClickCount(10));
        page.click("", new Page.ClickOptions().setButton(MouseButton.RIGHT));
        page.click("", new Page.ClickOptions().
                setModifiers(Arrays.asList(KeyboardModifier.CONTROL, KeyboardModifier.ALT)));
        page.dblclick("");
        page.check("");
        page.uncheck("");
    }
}
