package common;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RecordVideoSize;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

public class BaseTest {

    private static Playwright pw;
    private static Browser browser;
    private BrowserContext context;
    protected Page page;

    @BeforeAll
    static void beforeAll() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    void beforeEach() {
//        context = browser.newContext();

        // VIDEO RECORDING FROM TEST
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)
                .setRecordVideoDir(Paths.get("videos/"))
                .setRecordVideoSize(new RecordVideoSize(1920, 1080)));

        page = context.newPage();
    }

    @AfterEach
    void afterEach() {
        context.close();
    }

    @AfterAll
    static void afterAll() {
        pw.close();
    }
}
