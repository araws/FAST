package modul_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class _9VideoRecordingTest extends BaseTest {

    @Test
    void videoTest(){
        page.navigate("http://the-internet.herokuapp.com/login");
        page.getByLabel("Username").fill("demouser");
        page.getByLabel("Password").fill("Password123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
