package step.defination;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;

import com.example.Person.PersonApplication;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
	import org.springframework.boot.test.context.SpringBootTest;
	import io.cucumber.java.en.Given;
	@RunWith(Cucumber.class)
	@CucumberContextConfiguration
	@SpringBootTest(classes = PersonApplication.class)
	//@ContextConfiguration(classes = PersonApplication.class)
public class ExampleDefination {

	    private Response response;

	    @Given("Get Call to url")
	    public void getCallToUrl() {
	        RestAssured.baseURI = "http://localhost:8084/persons/get";
	        RequestSpecification httpRequest = RestAssured.given();
	        response = httpRequest.request(Method.GET);
	        System.out.println("Get person data from URL");
	    }

	    @Then("Response Code status is validated")
	    public void responseCodeStatusIsValidated() {
	        int responseStatus = response.getStatusCode();
	        System.out.println("Get the status code: " + responseStatus);
	        Assert.assertEquals(200, responseStatus);
	    }

	    @Then("verify response content type is {string}")
	    public void verifyResponseContentTypeIs(String contentType) {
	        Assertions.assertTrue(response.getContentType().contains(contentType));
	    }

	    @Then("print out the response body to console")
	    public void printOutTheResponseBodyToConsole() {
	        String responseBody = response.getBody().asString();
	        System.out.println("ResponseBody: " + responseBody);
	    }
}
