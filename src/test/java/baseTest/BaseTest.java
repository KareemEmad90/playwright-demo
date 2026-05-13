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
    public void setUp() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
        );

        context = browser.newContext();
        page = context.newPage();

        // ← Add these: CI runners are slower than local machines
        page.setDefaultTimeout(60000);
        page.setDefaultNavigationTimeout(60000);
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