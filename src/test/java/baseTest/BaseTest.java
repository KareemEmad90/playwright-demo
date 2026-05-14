package baseTest;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    void setUp() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(System.getenv("CI") != null)
        );

        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    public void tearDown() {
        try {
            if (context != null) context.close();
        } catch (Exception ignored) {}

        try {
            if (browser != null && browser.isConnected()) {
                browser.close();
            }
        } catch (Exception ignored) {}

        try {
            if (playwright != null) {
                playwright.close();
            }
        } catch (Exception ignored) {}
    }
}