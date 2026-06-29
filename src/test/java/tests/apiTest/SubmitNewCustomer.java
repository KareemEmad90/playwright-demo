package tests.apiTest;


import apis.CRMCustomerApi;
import org.junit.jupiter.api.Test;


public class SubmitNewCustomer {

    @Test
    public void submitNewCustomer() {
        CRMCustomerApi addNewCustomer = new CRMCustomerApi();
        addNewCustomer.addCustomerInfo();
    }



}
