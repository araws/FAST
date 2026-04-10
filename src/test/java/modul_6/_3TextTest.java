package modul_6;

import common.BaseTest;
import org.junit.jupiter.api.Test;

public class _3TextTest extends BaseTest {

    @Test
    void textTest() {
        page.navigate("https://the-internet.herokuapp.com/notification_message_rendered");

//        1. .innerHTML() - tags + text
//        System.out.println(page.innerHTML("#content"));

//        2. .innerText() - only text (visible on page)
//        System.out.println(page.innerText("#content"));

//        3. .textContent() - only text (visible and hidden on page)
//        System.out.println(page.textContent("#content"));

//        4. .getAttribute() - HTML attributes
//        System.out.println(page.getAttribute("div img", "alt"));
    }
}
