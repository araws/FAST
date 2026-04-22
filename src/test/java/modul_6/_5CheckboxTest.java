package modul_6;

import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class _5CheckboxTest extends BaseTest {

    @Test
    void checkboxTest(){
        page.navigate("https://the-internet.herokuapp.com/checkboxes");
        page.getByRole(AriaRole.CHECKBOX).first().check();
        page.getByRole(AriaRole.CHECKBOX).last().uncheck();

    }
}
