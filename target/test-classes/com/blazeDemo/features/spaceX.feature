@spaceX
Feature: verify the API response

  Scenario: Check for response code of the request
    Given I create GET URL request
    When Send a HTTP GET request
    Then I receive valid response

 