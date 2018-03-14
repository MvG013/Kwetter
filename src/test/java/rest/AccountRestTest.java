package rest;


import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static rest.RestTestSetup.Setup;

public class AccountRestTest {

    @BeforeClass
    public static void setup() {
        Setup();
    }

    @Test
    public void getAccountByID() {
        given().
                when().
                get("/accounts/id?id=1").
                then().
                statusCode(200).
                body("username", equalTo("Jens"),
                        "id", equalTo(1));
    }

    @Test
    public void getAllAccounts() {
        given().
                when().
                get("/accounts").
                then().
                statusCode(200).
                body(containsString("Jens"),
                        containsString("Joost"),
                        containsString("Henk"));
    }

}
