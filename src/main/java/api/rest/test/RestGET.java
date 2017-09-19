package api.rest.test;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.rest;

public class RestGET {

    private Response resp;

    private final String fakeApi = "http://fakerestapi.azurewebsites.net/";

    public RestGET() {
    }

    public void getWithoutParameters(String endPoint) {
        resp = rest().contentType("application/json").get(fakeApi + endPoint).then().extract().response();
    }

    public void getWithParameters(String endPoint, int id) {
        resp = rest().contentType("application/json").get(String.format("%s%s/%d", fakeApi, endPoint, id)).then().extract().response();
    }


    public void checkResponseCode(int code) {
        Assert.assertEquals(code, resp.getStatusCode());
    }

    public void checkFieldValueOfID(String field, String value, int id) {

        List list = resp.body().jsonPath().get();
        for (HashMap hm : (List<HashMap>) list) {
            if ((int) hm.get(("ID")) == id) {
                Assert.assertEquals("the expected value is not found", value, hm.get(field).toString());
                return;
            }
        }
        Assert.fail("There is not that ID");
    }

    public void checkFieldValueIfID(String field, String value, int id) {
        Assert.assertEquals("The recived ID is not the same", id, resp.body().jsonPath().getInt("ID"));
        Assert.assertEquals("the value is not the same", value, resp.body().jsonPath().getString(field));
    }


}