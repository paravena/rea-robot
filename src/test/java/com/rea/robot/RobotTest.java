package com.rea.robot;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RobotTest {
    private Robot robot;
    @Before
    public void initialize() {
        robot = new Robot();
        robot.setOrientation(Orientation.NORTH);
        robot.setPositionX(0);
        robot.setPositionY(0);
    }

    @Test
    public void testMove() {
        robot.move();
        assertEquals(new Integer(1), robot.getPositionY());
        assertEquals(new Integer(0), robot.getPositionX());
    }

    @Test
    public void testMovementBeyondLimits() {
        robot.setPositionX(Robot.X_LIMIT);
        robot.setPositionY(Robot.Y_LIMIT);
        robot.move();
        assertEquals(Robot.Y_LIMIT, robot.getPositionY());
        assertEquals(Robot.X_LIMIT, robot.getPositionX());
    }

    @Test
    public void testChangeOrientation() {
        assertEquals(Orientation.NORTH, robot.getOrientation());
        robot.changeOrientation(CommandName.LEFT);
        assertEquals(Orientation.WEST, robot.getOrientation());
        robot.changeOrientation(CommandName.LEFT);
        assertEquals(Orientation.SOUTH, robot.getOrientation());
        robot.changeOrientation(CommandName.LEFT);
        assertEquals(Orientation.EAST, robot.getOrientation());
        robot.changeOrientation(CommandName.LEFT);
        assertEquals(Orientation.NORTH, robot.getOrientation());
        robot.changeOrientation(CommandName.RIGHT);
        assertEquals(Orientation.EAST, robot.getOrientation());
        robot.changeOrientation(CommandName.RIGHT);
        assertEquals(Orientation.SOUTH, robot.getOrientation());
        robot.changeOrientation(CommandName.RIGHT);
        assertEquals(Orientation.WEST, robot.getOrientation());
        robot.changeOrientation(CommandName.RIGHT);
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }
}
