Feature: Robot Simulator
  As a user I want to use a Robot Simulator in order to simulate the movement of
  a robot toy in 5x5 table.

  Scenario: Place command
    Given I have a Robot
    When I enter following commands:
      | PLACE 1, 1, SOUTH  |
      | MOVE               |
      | RIGHT              |
      | MOVE               |
      | REPORT             |
    Then I expect to see the Robot in position 0,0, WEST

  Scenario: Moving out of limits
    Given I have a Robot
    When I enter following commands:
      | PLACE 4, 4, NORTH  |
      | MOVE               |
      | MOVE               |
      | REPORT             |
    Then I expect to see the Robot in position 4,5, NORTH

  Scenario: Commands are ignored if robot is not placed first
    Given I have a Robot
    When I enter following commands:
      | MOVE               |
      | MOVE               |
      | REPORT             |
    Then I expect to see an empty report

  Scenario: Wrong place command is ignored
    Given I have a Robot
    When I enter following commands:
      | PLACE -4, -4, NORTH  |
      | MOVE               |
      | MOVE               |
      | REPORT             |
    Then I expect to see an empty report
