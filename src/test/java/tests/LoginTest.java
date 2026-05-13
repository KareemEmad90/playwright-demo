package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.DBConnections;
import utils.VehicleQueries;

public class LoginTest extends BaseTest {


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
    void loginTest() {

        LoginPage login = new LoginPage(page);

        login.openApp("https://selfservices.rta.ae/oam/server/obrareq.cgi?encquery%3DWzSHuCxs6FUmjFmPZF6BT4f3zxJAcnQpM51aKq04zw68kIhuMHL42%2Bgp5esCGkPmyI6ccH3IcfNHKGJQp6Saco%2BeX6qBEs6IiXeqqxOpmD5yETdW443jVYO%2FaW2p0I9RK3mnC70h6VjcE0z1j3YqvOaRDfQBe01HM45Kup3KR5mUwXWUM7HwfQDwgsGLkkW6%2F%2F36ZsEOrGHGZ%2FEaPYXy5HWVENO%2Bj%2BhQ2eukKfVvjvBlDJZ2DUVxkXPMPjqjuMJJtT5VdNEDmMN0vpauxJckeuZv7Zevw0PJkzftS%2BMIz%2Fux39FUkq4S8rJSoHaVNWGcApdIDlFIo13P9%2FZu79%2BFWuXoPfT5KrUQwqMoL%2BVl%2F7pJEmi4En4%2B9jHGCU%2FhesC2XH0PtFOImSG0RMMUijJxyMAbx7iys0Fd1CjO%2B5xxaxqm3vKYUghWWW%2Bj1MYVVtWplp2Hw%2FXkICTo5YrNRzge37KTMIkYqbDff2jmd%2FrvBvgE%2Be6rzoMrA6wOaccWorkXTZWv8j6LtB%2BvWKdLqYaR71ktUFlDI2wWwYADAsFw3%2FzZR%2B8a17AwYOrFNGaVBeh%2B6RZV6cVyPLE%2FJzneyKgRQB8NzdfasqUI%2FHJbbR6m1gtqMVVer%2Flljl5nEsBUK59uwWFB3ZMP5LT7tNoyx3NURvW3ASweHuAXXOdxJGMeAzqPkQ5wYhkBnp%2B9GFA00SGBXkIVi%2FApGc0wnuvKZWTsKNMi6N8DyaIWrVapkYODhzitOIP63eVW2SpL96iBut9wAUDc3pbx0p8KRnvb8peeowNLZo8TvR4w0pzgLhXl9RZCMs%2FD7nu7TiFXWETOMr18dY4Pu5Bz66YaefXSpZJY8yYgqQ14YkFVOYN5obXqqGFI6Vrq2ILBGowsBvlsuVvkITFX0slsg%2Fv%2FOnL69fOpqzlj9hHBKdt1nd9uc20VOuubPa1ml5JoEEPgp5eLGAS%2BWM073YAuP8M4croSd%2Bq8bEedGuzSExcRF7ytPxebXH0qcXRR0XAnntcYve%2FSQVuzLGMZFasNaUAUMtrz1vJTdWfJjH303zZc65Db0KEL4c4buEUAYhlbXLWWOTTLaN0Y8GDqYe1GTMNMMVh0JG%2F32tRwBrvLAYe0B9lOoK0fgCCyiMw6SnqzHGnFX%2FsxFD%2B1gZw5zy7lut5xyhfGNiacKkDU1N1K1ehIVcgy8HTupPGBYeV%2B6dxd6Hku05cvrN19N3Qn4kRcAfgUhcXDpVWwFwZ1aKunWMCTqwhybxrzg3bwyselvi7Rwb2hRukWpsmnW2NsIa3M32DUlVgRtdytkZoL2ONiCB%2F0yvSFUBXxktrD6MUM3BB9KICR8dZ4Gj20MheLaa9KQaNIcTOUshs6eE88XC6vIh%2FYMxwttYa3StE%3D%20agentid%3DOHS12C_WG%20ver%3D1%20crmethod%3D2&ECID-Context=1.00jg49rtkhcFw00Fzzw0w00003GK001CeZ%3BkXghlXjE0ZJOoOTLkKPOoLRKlSODoITT_G");

        login.enterUsername("test");
        login.enterPassword("test");
        login.clickLogin();

        System.out.println("Test completed");
        System.out.println("GitHub Actions Running");
    }

    /*@AfterAll
    static void tearDownAll() {
        DBConnections.close();
    }*/
}