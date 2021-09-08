Feature: the version can be retrieved
  Scenario: client makes call to GET /users/1
    When the client calls /api/v1/users/1
    Then the client receives status code of 200
    And the client receives server version 1.0