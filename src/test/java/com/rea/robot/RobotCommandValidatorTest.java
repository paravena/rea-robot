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
    public void testValidateRobotPlaceCommand() {
        String commandLine = "PLACE 0, 0, NORTH";
        RobotCommand robotCommand = robotCommandValidator.validateCommand(commandLine);
        assertNotNull(robotCommand);
        assertEquals(CommandName.PLACE, robotCommand.getName());
        assertEquals(Orientation.NORTH, robotCommand.getOrientation());
        assertEquals(new Integer(0), robotCommand.getPositionX());
        assertEquals(new Integer(0), robotCommand.getPositionY());
    }

    @Test
    public void testValidateWrongPlaceRobotCommand() {
        String commandLine = "PLACE 0, 0, NOWHERE";
        RobotCommand robotCommand = robotCommandValidator.validateCommand(commandLine);
        assertNull(robotCommand);
    }

    @Test
    public void testValidateRobotLeftCommand() {
        String commandLine = "LEFT";
        RobotCommand robotCommand = robotCommandValidator.validateCommand(commandLine);
        assertNotNull(robotCommand);
        assertEquals(CommandName.LEFT, robotCommand.getName());
        assertNull(robotCommand.getOrientation());
        assertNull(robotCommand.getPositionX());
        assertNull(robotCommand.getPositionY());
    }

    @Test
    public void testValidateRobotRightCommand() {
        String commandLine = "RIGHT";
        RobotCommand robotCommand = robotCommandValidator.validateCommand(commandLine);
        assertNotNull(robotCommand);
        assertEquals(CommandName.RIGHT, robotCommand.getName());
        assertNull(robotCommand.getOrientation());
        assertNull(robotCommand.getPositionX());
        assertNull(robotCommand.getPositionY());
    }

    @Test
    public void testValidateRobotMoveCommand() {
        String commandLine = "MOVE";
        RobotCommand robotCommand = robotCommandValidator.validateCommand(commandLine);
        assertNotNull(robotCommand);
        assertEquals(CommandName.MOVE, robotCommand.getName());
        assertNull(robotCommand.getOrientation());
        assertNull(robotCommand.getPositionX());
        assertNull(robotCommand.getPositionY());
    }

    @Test
    public void testValidateRobotReportCommand() {
        String commandLine = "REPORT";
        RobotCommand robotCommand = robotCommandValidator.validateCommand(commandLine);
        assertNotNull(robotCommand);
        assertEquals(CommandName.REPORT, robotCommand.getName());
        assertNull(robotCommand.getOrientation());
        assertNull(robotCommand.getPositionX());
        assertNull(robotCommand.getPositionY());
    }

    @Test
    public void testValidateRobotCommandLowercase() {
        String commandLine = "report";
        RobotCommand robotCommand = robotCommandValidator.validateCommand(commandLine);
        assertNotNull(robotCommand);
        assertEquals(CommandName.REPORT, robotCommand.getName());
        assertNull(robotCommand.getOrientation());
        assertNull(robotCommand.getPositionX());
        assertNull(robotCommand.getPositionY());
    }

    @Test
    public void testValidateWrongRobotCommand() {
        String commandLine = "FLY";
        RobotCommand robotCommand = robotCommandValidator.validateCommand(commandLine);
        assertNull(robotCommand);
    }
}
