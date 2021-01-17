Feature:  Validating place API's

Scenario Outline: Verify if place is being successfully added using AddPlaceAPI

	Given Add Place Payload with "<name>" "<Language>" "<address>"
	When user calls "addPlaceAPI" with HTTP "Post" Request
	Then the API call is success with status code 
	And "status" in response body is "OK"
	And "scope" in response body is "App"
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
	
	Examples:
	|name		  | language|address		   |
	|deeksha House| English |Nehru Park Morena | 
#	|Cuttooo House| French 	|Gandhi Colony Morena | 


Scenario: Verify if delete place functionality is working
    Given DeletPlace Payload
    When user calls "deletePlaceAPI" with HTTP "Post" Request
    Then the API call is success with status code
    And "status" in response body is "OK"
    
	
	
	
	
	
	
	
	


