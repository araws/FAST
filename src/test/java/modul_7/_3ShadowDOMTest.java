package modul_7;

import common.BaseTest;
import org.junit.jupiter.api.Test;

public class _3ShadowDOMTest extends BaseTest {

    @Test
    void shadowDOMTest() {
        page.navigate("https://the-internet.herokuapp.com/shadowdom");
        System.out.println(page.locator("span[slot=my-text]").innerText()); //if shadow-root is closed, PW cannot rich it
    }
}
