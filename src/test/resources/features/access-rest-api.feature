Feature: Do a succesful RESt call
  As a actor I want to do a successful rest call


  @happy
  Scenario: With correct input I expect a correct result
    Given A document is modified for a request
    When I do a correct REST request
    Then I expect OK status code

  @unhappy
  Scenario: With correct input I expect a incorrect result
    Given A document is modified for a request
    When I do a correct REST request
    Then I expect OK status code