package modul_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _6UploadFileTest extends BaseTest {

    @Test
    void uploadSingleFileTest() {
        page.navigate("https://the-internet.herokuapp.com/upload");

        page.setInputFiles("#file-upload", Paths.get("uploads/file_to_upload.txt"));
        page.setInputFiles("#file-upload", new Path[0]); // cleans chosen file
        page.setInputFiles("#file-upload", Paths.get("uploads/file_to_upload_1.txt"));

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload")).click();

        assertThat(page.getByText("File Uploaded!")).isVisible();
    }
}
