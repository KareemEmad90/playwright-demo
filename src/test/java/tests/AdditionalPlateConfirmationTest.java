package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import org.junit.jupiter.api.*;
import pages.AdditionalPlateConfirmationPage;

public class AdditionalPlateConfirmationTest {
    static Playwright playwright;
    Browser browser;
    Page page;
    AdditionalPlateConfirmationPage confirmationPage;

    @BeforeAll
    static void globalSetup() {
        playwright = Playwright.create();
    }

    @BeforeEach
    void setup() {
        browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
        page = browser.newPage();
        confirmationPage = new AdditionalPlateConfirmationPage(page);
        confirmationPage.openPage("http://localhost:8100/");
    }

    @AfterEach
    void tearDown() {
        page.close();
        browser.close();
    }

    @AfterAll
    static void globalTearDown() {
        playwright.close();
    }

    @Test
    void testAdditionalPlateConfirmationElements() {
        Assertions.assertTrue(confirmationPage.isConfirmationContainerVisible(), "Confirmation container should be visible");
        Assertions.assertTrue(confirmationPage.isConfirmationMessageVisible(), "Confirmation message should be visible");
        Assertions.assertTrue(confirmationPage.isDownloadLinkVisible(), "Download link should be visible");
    }
}
