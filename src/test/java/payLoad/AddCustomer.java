package payLoad;

public class AddCustomer {

    public static String SubmitNewCustomerPayLoad(String  email) {

        String payload="{\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"phone\": \"+971501234567\",\n" +
                "  \"status\": \"ACTIVE\"\n" +
                "}";

        return payload;
    }
}
