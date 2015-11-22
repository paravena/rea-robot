package com.rea.robot;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class RobotSimulatorTest {
    private RobotSimulator robotSimulator;

    @Before
    public void initialize() {
        robotSimulator = new RobotSimulator();
    }

    @Test
    public void testReadInput() {
        String input = "PLACE 1,2,EAST\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        robotSimulator.readInput(in);
    }

}
