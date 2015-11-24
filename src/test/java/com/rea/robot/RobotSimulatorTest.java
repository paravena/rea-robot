package com.rea.robot;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RobotSimulatorTest {
    private RobotSimulator robotSimulator;

    @Before
    public void initialize() {
        robotSimulator = spy(new RobotSimulator(System.out));
        robotSimulator.robotCommandValidator = spy(RobotCommandValidator.getInstance());
    }

    @Test
    public void testProcessPlaceCommand() {
        String input = "PLACE 1,2,EAST\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        robotSimulator.readInput(in);
        RobotCommand robotCommand = new RobotCommand(CommandName.PLACE, 1, 2, Orientation.EAST);
        verify(robotSimulator.robotCommandValidator).validateCommand(matches("PLACE 1,2,EAST"));
        verify(robotSimulator).processCommand(eq(robotCommand));
        assertEquals(Orientation.EAST, robotSimulator.robot.getOrientation());
        assertEquals(new Integer(1), robotSimulator.robot.getPositionX());
        assertEquals(new Integer(2), robotSimulator.robot.getPositionY());
    }

    @Test
    public void testProcessMoveCommand() {
        String input = "PLACE 1,2,EAST\nMOVE\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        robotSimulator.readInput(in);
        verify(robotSimulator.robotCommandValidator, times(2)).validateCommand(anyString());
        verify(robotSimulator, times(2)).processCommand(any(RobotCommand.class));
        assertEquals(Orientation.EAST, robotSimulator.robot.getOrientation());
        assertEquals(new Integer(2), robotSimulator.robot.getPositionX());
        assertEquals(new Integer(2), robotSimulator.robot.getPositionY());
    }

    @Test
    public void testProcessLeftCommand() {
        String input = "PLACE 1,2,EAST\nLeft\nmove\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        robotSimulator.readInput(in);
        verify(robotSimulator.robotCommandValidator, times(3)).validateCommand(anyString());
        verify(robotSimulator, times(3)).processCommand(any(RobotCommand.class));
        assertEquals(Orientation.NORTH, robotSimulator.robot.getOrientation());
        assertEquals(new Integer(1), robotSimulator.robot.getPositionX());
        assertEquals(new Integer(3), robotSimulator.robot.getPositionY());
    }

    @Test
    public void testProcessRightCommandAndIgnoreOneOfThem() {
        String input = "PLACE 4,4,SOUTH\nRight\nRUN\nmove\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        robotSimulator.readInput(in);
        verify(robotSimulator.robotCommandValidator, times(4)).validateCommand(anyString());
        verify(robotSimulator, times(3)).processCommand(any(RobotCommand.class));
        assertEquals(Orientation.WEST, robotSimulator.robot.getOrientation());
        assertEquals(new Integer(3), robotSimulator.robot.getPositionX());
        assertEquals(new Integer(4), robotSimulator.robot.getPositionY());
    }
}
