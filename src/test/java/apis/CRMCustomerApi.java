package apis;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import payLoad.AddCustomer;


import static io.restassured.RestAssured.given;


public class CRMCustomerApi {
    String email = "Kareem" + System.currentTimeMillis() + "@example.com";

    public Response addCustomerInfo (){
        RestAssured.useRelaxedHTTPSValidation();
        String baseURI = "http://172.18.125.188:8201/api/customers";


        String checkEligibilityBody = AddCustomer.SubmitNewCustomerPayLoad(email);
        Response response = (Response) given().log().all()
                .auth().preemptive().basic("CIS_USER","cisTestUser")
                .header("Content-Type","application/json")
                .body(checkEligibilityBody)
                .when()
                .post(baseURI)
                .then().log().all()
                .extract().response();
        return response;
    }

}

