Feature: Test Github Api

@CreateRepo
Scenario: Add github repository
When Set POST request HEADER and body parameter
And Send POST HTTP request
Then I receive valid HTTP Response code as 201

@GetRepo
Scenario: Get Github details
When Set Get Request HEADER
And Send GET HTTP request
Then I receive valid HTTP Response code as 200

@UpdateRepo
Scenario: Patch github repository
When Set Patch request HEADER and body parameter
And Send Patch HTTP request
Then I receive valid HTTP Response code as 200

@DeleteRepo
Scenario: Delete github repository
When Set Delete request HEADER
And Send Delete HTTP request
Then I receive valid HTTP Response code as 204