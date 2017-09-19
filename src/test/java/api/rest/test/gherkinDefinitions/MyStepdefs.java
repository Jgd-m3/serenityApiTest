package api.rest.test.gherkinDefinitions;

import api.rest.test.serenitySteps.ApiSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class MyStepdefs {

    @Steps
    private ApiSteps apiSteps;


    /**
     * GET
     * @param arg0
     * @throws Throwable
     */

    @Given("^the next GET end-point \"([^\"]*)\"$")
    public void theNextGETEndPoint(String arg0) throws Throwable {
        apiSteps.getWithoutParameters(arg0);
    }

    @When("^the response status code should be (\\d+)$")
    public void theResponseStatusCodeShouldBe(int arg0) throws Throwable {
        apiSteps.checkResponseCode(arg0);
    }

    @Then("^check if the field \"([^\"]*)\" contains the value \"([^\"]*)\" for id (\\d+)$")
    public void checkIfTheFieldContainsTheValueForIdId(String arg0, String arg1, int arg2) throws Throwable {
        apiSteps.checkFieldValueOfID(arg0, arg1, arg2);
    }

    @Given("^the next GET end-point \"([^\"]*)\" and the ID (\\d+)$")
    public void theNextGETEndPointAndTheIDId(String arg0, int arg1) throws Throwable {
        apiSteps.getWithParameters(arg0, arg1);
    }

    @Then("^check if the field \"([^\"]*)\" contains the value \"([^\"]*)\" if id (\\d+)$")
    public void checkIfTheFieldContainsTheValueIfIdId(String arg0, String arg1, int arg2) throws Throwable {
        apiSteps.checkFieldValueIfID(arg0, arg1, arg2);
    }


    /**
     * POST
     * @param arg0
     * @throws Throwable
     */

    @Given("^the next POST end-point \"([^\"]*)\"$")
    public void theNextPOSTEndPoint(String arg0) throws Throwable {
        apiSteps.postData(arg0);
    }

    @When("^split the string of fields \"([^\"]*)\" and string of values \"([^\"]*)\"$")
    public void splitTheStringOfFieldsAndStringOfValues(String arg0, String arg1) throws Throwable {
        apiSteps.splitTheFieldsAndValues(arg0, arg1);
    }

    @And("^send the POST call$")
    public void sendThePOSTCall() throws Throwable {
        apiSteps.sendPost();
    }

    @Then("^the response post status code should be (\\d+)$")
    public void theResponsePostStatusCodeShouldBe(int arg0) throws Throwable {
        apiSteps.checkStatusCodePost(arg0);
    }

    @And("^returned id is the same (\\d+)$")
    public void returnedIdIsTheSameId(int id) throws Throwable {
        apiSteps.checkIdOfTheResponse(id);
    }


    @And("^the values of the fields are correctly$")
    public void theValuesOfTheFieldsAreCorrectly() throws Throwable {
        apiSteps.checkTheFieldsOfTheResponse();
    }

    @And("^I test array values \"([^\"]*)\"$")
    public void iTestArrayValues(List<String> arg0) throws Throwable {
        System.out.println("Longitud: "+arg0.size());
    }
}
