Feature: Robot Simulator
  As a user I want to use a Robot Simulator in order to simulate the movement of
  a robot toy in 5x5 table.

  Scenario: Place command
    Given I have a Robot
    When I place the Robot in position 0, 0 with NORTH orientation
    Then I expect to see the Robot initialized in previous position