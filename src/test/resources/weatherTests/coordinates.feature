Feature: Testing coordinates for weather
  Scenario: Coordinates test
    When we getting weather from server
    Then lon is -0.13
    And lat is 51.51