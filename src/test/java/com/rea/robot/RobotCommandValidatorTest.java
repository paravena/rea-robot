package com.rea.robot;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

import org.junit.Before;
import org.junit.Test;

public class RobotCommandValidatorTest {
    private RobotCommandValidator robotCommandValidator;
    @Before
    public void initialize() {
        robotCommandValidator = RobotCommandValidator.getInstance();
    }

    @Test
    public void testValidateRobotCommand() {
        String commandLine = "PLACE 0, 0, NORTH";
        RobotCommand robotCommand = robotCommandValidator.validateCommand(commandLine);
        assertNotNull(robotCommand);
        assertEquals(CommandName.PLACE, robotCommand.getName());
        assertEquals(new Integer(0), robotCommand.getPositionX());
        assertEquals(new Integer(0), robotCommand.getPositionY());
    }

    @Test
    public void testValidateWrongRobotCommand() {
        String commandLine = "PLACE 0, 0, NOWHERE";
        RobotCommand robotCommand = robotCommandValidator.validateCommand(commandLine);
        assertNull(robotCommand);
    }
}
