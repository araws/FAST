package modul_6;

import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class _4DropdownTest extends BaseTest {

    @Test
    void dropdownTest() {
        page.navigate("https://the-internet.herokuapp.com/dropdown");
        page.selectOption("#dropdown", "1"); //value
//        page.selectOption("#dropdown", "Option 2"); //text
    }

    @Test
    void multiselectTest() {
        page.navigate("https://testpages.eviltester.com/pages/forms/html-form/");
        page.getByRole(AriaRole.LISTBOX).selectOption(new String[] {"ms2", "ms3"});
    }
}
