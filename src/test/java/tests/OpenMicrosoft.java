package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.LoginPage;


@Execution(ExecutionMode.CONCURRENT)
public class OpenMicrosoft extends BaseTest {


  /*  @BeforeAll
    static void runDataBaseQueries() {
        DBConnections.connect();

        String result = VehicleQueries.getTrafficId(
                "SELECT id FROM traffic.tf_stp_traffic_files WHERE traffic_no = '13548788'",
                "ID"
        );

        System.out.println(result);
    }*/

    @Test
    void test3() {
        page.navigate("https://microsoft.com");
        page.waitForTimeout(10000);
        System.out.println("Test completed3");
        System.out.println("TITLE: " + page.title());

    }

    /*@AfterAll
    static void tearDownAll() {
        DBConnections.close();
    }*/
}