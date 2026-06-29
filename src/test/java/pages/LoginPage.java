package pages;

import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {

    private Page page;

    // Locators
    private String username = "#username";//input[@id= 'username']
    private String password = "#password";//input[@id= 'password']
    private String loginBtn = "//button//i[contains(text(), ' Login')]";
    private String message = "//h4[@class='subheader']";
    private String logoutBtn ="//i[@class='icon-2x icon-signout']";

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
    public void clickLogout() {
        page.click(logoutBtn);

    }
    public String getMessage() {
        String txtMsg = page.locator(message).textContent();

        if (txtMsg == null) return "";

        String keyword = "Area.";

        int index = txtMsg.indexOf(keyword);

        String result = index != -1
                ? txtMsg.substring(0, index + keyword.length())
                : txtMsg;

        System.out.println("HERE IS TRIM MESSAGE" + result); // 👈 sout here

        return result;

    }
    public void checkBackToLoginPage() {
        assert page.url().contains("login");


    }
}