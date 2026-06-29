package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.LoginPage;
import utils.DBConnections;


@Execution(ExecutionMode.CONCURRENT)
public class LoginTestGPT extends BaseTest {




    @Test
    void loginTest() {

        LoginPage login = new LoginPage(page);

        login.openApp("https://the-internet.herokuapp.com/login");

        login.enterUsername("tomsmith");
        login.enterPassword("SuperSecretPassword!");
        login.clickLogin();
        login.getMessage();
        login.clickLogout();
        login.checkBackToLoginPage();



    }



    @AfterAll
    static void tearDownAll() {
        DBConnections.close();
    }
}