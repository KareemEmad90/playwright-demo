package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.DBConnections;
import utils.VehicleQueries;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;


@Execution(ExecutionMode.CONCURRENT)
public class LoginTest extends BaseTest {


    @BeforeAll
    static void runDataBaseQueries() {


        DBConnections.connect();

        /*String result = VehicleQueries.getTrafficId(
                "SELECT id FROM traffic.tf_stp_traffic_files WHERE traffic_no = '13548788'",
                "ID"
        );

        System.out.println("KareeeeeeeeeeeeeeeeeeeeeeeeeeeemEmad  "  +result);*/
    }

    @Test
    void loginTest() {

        LoginPage login = new LoginPage(page);

        login.openApp("https://www.google.com/");

        //login.enterUsername("test");
        //login.enterPassword("test");
        //login.clickLogin();

        System.out.println("Test completed1");
        System.out.println("URL: " + page.url());
        System.out.println("TITLE: " + page.title());
        System.out.println("CONTENT: " + page.content());
        System.out.println(Thread.currentThread().getName());
        System.out.println("KareeeeeeeeeeeeeeeeeeeeeeeeeeeemEmad111111  " );

    }



    @AfterAll
    static void tearDownAll() {
        DBConnections.close();
    }
}