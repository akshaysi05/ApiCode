Feature: Validating Place API's'

Scenario Outline: Verify if Place is being Sucessfully added using AddPlaceApi
      Given Add Place PayLoad with "<name>" "<language>" "<address >"
      When user calls "AddPlaceAPI" with "POST" http request
      Then the API call got Success with status code 200
      And "status" in response body is "OK"
        And "scope" in response body is "APP"
        And Verify place_Id created maps to "<name>" using "getPlaceApi"
      
Examples:
     |name  |language|address    |
     |herry |English |City Center|
 #    |Portar|Hindi   |India      |
 
 Scenario: verify if Delete place functionality is working 
       Given DeletePlace Payload
       When user calls "deletePlaceApi" with "POST" http request
      Then the API call got Success with status code 200
      And "status" in response body is "OK"
       