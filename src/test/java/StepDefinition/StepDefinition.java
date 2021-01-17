package StepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import POJO.AddPlace;
import POJO.location;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;


public class StepDefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification rep;
	RequestSpecification reqSpec;
	Response response;
	
	String place_id;
	JsonPath js;
	
	static String placeId;
	
	
	TestDataBuild data= new TestDataBuild();
	
	

	    @Given("^Add Place Payload with {string}  {string}  {string}$")
	    public void add_place_payload(String name, String language, String address) throws Throwable {

			 reqSpec= given().spec(requestSpecification())
					.body(data.addPlacePayload(name, language, address));
	    }

	    @When("^user calls \"([^\"]*)\" with HTTP \"([^\\\"]*)\" Request$")
	    public void user_calls_something_with_http_post_request(String resource, String method)
		{
	    	//constructors will be called with value of resource which you pass
	    		APIResources resourceAPI= APIResources.valueOf(resource);
	    		System.out.println(resourceAPI.addPlaceAPI);
			ResponseSpecification rep=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
			if(method.equalsIgnoreCase("Post"))
			response=reqSpec.when().post(resourceAPI.getResource());
			else if(method.equalsIgnoreCase("Get"))
				response=reqSpec.when().post(resourceAPI.getResource());
			else
				response=reqSpec.when().post(resourceAPI.getResource());
		}

	    @Then("^the API call is success with status code $")
	    public void the_api_call_is_success_with_status_code(Integer int1)
		{
			assertEquals(response.getStatusCode(), 200);
	    }

	    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	    public void something_in_response_body_is_something(String keyValue, String Expectedvalue) throws Throwable {
	    	
			
			assertEquals(getJsonPath(response, keyValue), Expectedvalue);
	    }
	     
	    @And("^verify place_Id created maps to {string}  {string}  {string}$")
	    public void verify_place_Id_created_maps(String expectedName, String resource) throws Throwable {
	    	
	    	 placeId=getJsonPath(response, "place_id");
	    	 reqSpec= given().spec(requestSpecification()).queryParam("place_Id", placeId);
	    	 user_calls_something_with_http_post_request(resource, "GET");
	    	 String actualName=getJsonPath(response, "name");
	    	 assertEquals(expectedName, actualName);
	    	
	    }
	    
	    @Given("^DeletPlace Payload")
	    public void deletePlace_Payload(String placeId )throws Throwable {

			 reqSpec= given().spec(requestSpecification())
					.body(data.deletePlacePayload(placeId);
	    }

	}

