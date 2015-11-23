package com.rea.robot.bdd.steps;

import com.rea.robot.CommandName;
import com.rea.robot.Orientation;
import com.rea.robot.RobotCommand;
import com.rea.robot.RobotSimulator;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RobotSimulatorSteps {
    private RobotSimulator robotSimulator;


    @Given("^I have a Robot$")
    public void createRobot() {
        robotSimulator = new RobotSimulator();
    }

    @When("^I place the Robot in position (\\d), (\\d) with (NORTH|SOUTH|EAST|WEST) orientation$")
    public void placeRobotInGivenPosition(int x, int y, String orientation) {
        robotSimulator.processCommand(new RobotCommand(CommandName.PLACE, x, y, Orientation.valueOf(orientation)));
    }

    @Then("^I expect to see the Robot initialized in previous position$")
    public void verifyPosition() {
        throw new PendingException();
    }
}
