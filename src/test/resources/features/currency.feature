Feature: Api Tests for Coin Market API

  @task-1
  Scenario: Search for Ethereum Currency with its ID
    Given I Retrieve the Ethereum Currency with its ID

  @task-2
  Scenario: Retrieve the ids of all the Currencies and Covert it to Bolivarcoin
    Given I retrieve id of all currencies
    Then I convert them to Bolivarcoin

  @task-3
  Scenario:
    Given I retrieve first ten currencies
    Then I verify that mineable exists in response

