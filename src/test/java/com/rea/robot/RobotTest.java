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

}
