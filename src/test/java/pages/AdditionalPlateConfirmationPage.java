package pages;

import com.microsoft.playwright.Page;

public class AdditionalPlateConfirmationPage {
    private final Page page;

    // Locators
    private final String confirmationContainer = ".additionaPplate-confirmation";
    private final String confirmationMessage = "text=succeffulyCollected";
    private final String downloadLink = ".downloadLink";

    public AdditionalPlateConfirmationPage(Page page) {
        this.page = page;
    }

    public void openPage(String url) {
        page.navigate(url);
    }

    public boolean isConfirmationContainerVisible() {
        return page.isVisible(confirmationContainer);
    }

    public boolean isConfirmationMessageVisible() {
        return page.isVisible(confirmationMessage);
    }

    public String getConfirmationText() {
        return page.textContent(confirmationContainer);
    }

    public boolean isDownloadLinkVisible() {
        return page.isVisible(downloadLink);
    }

    public void clickDownloadLink() {
        page.click(downloadLink);
    }
}
