package api.rest.test.serenitySteps;

import api.rest.test.RestGET;
import api.rest.test.RestPOST;
import net.thucydides.core.annotations.Step;

public class ApiSteps {

    private RestGET getService = new RestGET();
    private RestPOST postService = new RestPOST();

    public ApiSteps() {
    }

    @Step
    public void getWithoutParameters(String endPoint) {
        getService.getWithoutParameters(endPoint);
    }

    @Step
    public void getWithParameters(String endPoint, int id) {
        getService.getWithParameters(endPoint, id);
    }

    @Step
    public void checkResponseCode(int code) {
        getService.checkResponseCode(code);
    }

    @Step
    public void checkFieldValueOfID(String field, String value, int id) {
        getService.checkFieldValueOfID(field, value, id);
    }

    @Step
    public void checkFieldValueIfID(String field, String value, int id) {
        getService.checkFieldValueIfID(field, value, id);
    }

    @Step
    public void postData(String endPoint) {
        postService.postData(endPoint);
    }

    @Step
    public void checkStatusCodePost(int code){
        postService.checkStatusCodePost(code);
    }

    @Step
    public void splitTheFieldsAndValues(String fields, String values) {
        postService.splitTheFieldsAndValues(fields, values);
    }

    @Step
    public void sendPost() {
        postService.sendPost();
    }

    @Step
    public void checkIdOfTheResponse(int id) {
        postService.checkIdOfTheResponse(id);
    }

    @Step
    public void checkTheFieldsOfTheResponse() {
        postService.checkTheFieldsOfTheResponse();
    }

}
