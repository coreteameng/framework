Feature: Heyman Test

  Scenario: Heyman Ex

    Given User is already on "pagename" Page
    When title of "pagename" page is "Test"
    Then user enters "id", value : "value"
    Then user clicks on "id" button
    Then Close the browser
