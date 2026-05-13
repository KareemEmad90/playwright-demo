package baseTest;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    public void setUp() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(500)
        );

        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    public void tearDown() {

        try {
            if (context != null) context.close();
        } catch (Exception e) {
            System.out.println("Context already closed");
        }

        try {
            if (browser != null) browser.close();
        } catch (Exception e) {
            System.out.println("Browser already closed");
        }

        try {
            if (playwright != null) playwright.close();
        } catch (Exception e) {
            System.out.println("Playwright already closed");
        }
    }
}