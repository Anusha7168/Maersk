@bookingTicket
Feature: verify the booking functionality

  Scenario: Book a trip from Boston to New York
    Given Initialize the browser with chrome
    And Navigate to url
    Given Choose Boston from the departure city dropdown list
    And Choose New York from the arrival city dropdown list
    
    Given Click on Find Flights button
    Then Check if we land on the Search Flights page

  Scenario: Choose flight
    Given search flights page is opened and flights are available
    And choose united airlines flight
    Then Check if we land on the Purchase Flights page
  
  Scenario: Purchase Flight
  	Given Correct flight is selected
    And fill the form details
    Then Check if we land on the confirmation page
    And close browser