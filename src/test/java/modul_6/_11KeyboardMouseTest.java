package modul_6;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.MouseButton;
import common.BaseTest;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class _11KeyboardMouseTest extends BaseTest {

    @Test
    void keyboardTest() {
        page.navigate("https://the-internet.herokuapp.com/key_presses");
        page.locator("#target").click();
        Keyboard keyboard = page.keyboard();
        keyboard.press("ArrowUp");

        assertThat(page.getByText("You entered: UP")).isVisible();
    }

    @Test
    void mouseTest() {
        page.navigate("https://the-internet.herokuapp.com/context_menu");
        Mouse mouse = page.mouse();

        page.onceDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.accept();
        });

        mouse.click(250, 250, new Mouse.ClickOptions().setButton(MouseButton.RIGHT));
    }

    @Test
    void dragAndDropTest() {
        page.navigate("https://the-internet.herokuapp.com/drag_and_drop");
        Locator element1 = page.locator("#column-a");
        Locator element2 = page.locator("#column-b");
        element1.dragTo(element2);
    }
}
