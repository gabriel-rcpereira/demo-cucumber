Feature: the version can be retrieved
  Scenario: client makes call to GET /users/1
    Given the api "/api/v1/users/1"
    When the client sends a get request
    Then the client receives status code of 200
    And the client receives a response body equals to "user-body"