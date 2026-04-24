package modul_7;

import com.microsoft.playwright.Download;
import common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class _5DownloadFileTest extends BaseTest {

    @Test
    void downloadWithHandlerTest() {
        page.navigate("https://the-internet.herokuapp.com/download");

        // Handler always before click
        page.onDownload(download -> download.saveAs(Paths.get("downloads/ceny.pdf")));

        // CLICK
        page.getByText("ceny.pdf").click();
    }

    @Test
    void downloadWithSaveTest() {
        page.navigate("https://the-internet.herokuapp.com/download");

        // CLICK
        Download download = page.waitForDownload(() -> page.getByText("ceny.pdf").click());

        //SAVE
        download.saveAs(Paths.get("downloads/ceny1.pdf"));
    }
}
