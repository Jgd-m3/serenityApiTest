package api.rest.test;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Set;

import static net.serenitybdd.rest.SerenityRest.rest;

public class RestPOST {

    private Response resp;
    private String endPoint;

    private final String fakeApi = "http://fakerestapi.azurewebsites.net/";

    private HashMap entriesMap;


    public void postData(String endPoint) {
        this.endPoint = endPoint;
    }


    public void splitTheFieldsAndValues(String fields, String values) {
        String[] flds = fields.split("#!");
        String[] vals = values.split("#!");
//        Assert.assertEquals("there is not the same amount of fields and values", flds.length, vals.length);

        entriesMap = new HashMap<String, String>();

        for (int i = 0; i < flds.length; i++) {
            entriesMap.put(flds[i], vals[i]);
        }
        Assert.assertEquals("The hashMap hadn't be filled properly", flds.length, entriesMap.size());
    }

    public void sendPost() {
        Gson gson = new Gson();
        String json = gson.toJson(entriesMap);

        resp = rest().contentType("application/json").body(json).when().post(fakeApi + endPoint).then().extract().response();
    }

    public void checkStatusCodePost(int code) {
        Assert.assertEquals(code, resp.getStatusCode());
    }

    public void checkIdOfTheResponse(int id) {
        Assert.assertEquals(id, resp.body().jsonPath().getInt("ID"));
    }

    public void checkTheFieldsOfTheResponse() {

        Set<String> list = entriesMap.keySet();
        for (String key : list) {
            Assert.assertEquals(entriesMap.get(key), resp.body().jsonPath().get(key).toString());
        }
    }
}
