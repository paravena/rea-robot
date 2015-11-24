package com.rea.robot.bdd.steps;

import com.rea.robot.CommandName;
import com.rea.robot.Orientation;
import com.rea.robot.RobotCommand;
import com.rea.robot.RobotSimulator;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.*;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class RobotSimulatorSteps {
    private RobotSimulator robotSimulator;
    private ByteArrayOutputStream result;

    @Given("^I have a Robot$")
    public void createRobot() {
        result = new ByteArrayOutputStream();
        robotSimulator = new RobotSimulator(result);
    }

    @When("^I enter following commands:$")
    public void processGivenRobotCommands(DataTable dataTable) {
        List<String> robotCommands = dataTable.asList(String.class);
        StringWriter sw = new StringWriter();
        for (String commandLine : robotCommands) {
            sw.append(commandLine).append("\n");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(sw.toString().getBytes());
        robotSimulator.readInput(bais);
    }

    @Then("^I expect to see the Robot in position (\\d),(\\d), (\\w+)$")
    public void checkReport(Integer positionX, Integer positionY, String orientation) {
        assertEquals(positionX + "," + positionY + "," + orientation + "\n", result.toString());
    }

    @Then("^I expect to see an empty report$")
    public void checkEmptyReport() {
        assertEquals("", result.toString());
    }
}
