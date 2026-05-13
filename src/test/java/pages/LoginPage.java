package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    // Locators
    private String username = "#username";
    private String password = "#password";
    private String loginBtn = "//input[@name = 'submitBtn']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void openApp(String url) {
        page.navigate(url);
    }

    public void enterUsername(String user) {
        page.fill(username, user);
    }

    public void enterPassword(String pass) {
        page.fill(password, pass);
    }

    public void clickLogin() {
        page.click(loginBtn);
    }
}