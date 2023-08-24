Feature: Validating Place API's'

Scenario Outline: Verify if Place is being Sucessfully added using AddPlaceApi
      Given Add Place PayLoad with "<name>" "<language>" "<address >"
      When user calls "AddPlaceAPI" with "POST" http request
      Then the API call got Success with status code 200
      And "status" in response body is "OK"
        And "scope" in response body is "APP"
      
Examples:
     |name  |language|address    |
     |herry |English |City Center|
     |Portar|Hindi   |India      |
     