Feature: Test to retrieve get method of Person

  Scenario Outline: Send a valid Request to GET Person
    Given Get Call to url
    Then Response Code status is validated
    And verify response content type is "<contentType>"
    And print out the response body to console

    Examples: 
      | contentType      |
      | application/json |

