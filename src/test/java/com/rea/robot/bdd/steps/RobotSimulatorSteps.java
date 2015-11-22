package com.rea.robot.bdd.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RobotSimulatorSteps {
    @Given("^I have a Robot$")
    public void createRobot() {
        throw new PendingException();
    }

    @When("^I place the Robot in position (\\d), (\\d) with (NORTH|SOUTH|EAST|WEST) orientation$")
    public void placeRobotInGivenPosition(int x, int y, String orientation) {
        throw new PendingException();
    }

    @Then("^I expect to see the Robot initialized in previous position$")
    public void verifyPosition() {

    }
}
