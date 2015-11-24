package com.rea.robot;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StartTest {
    @Test
    public void testVersion() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream console = System.out;
        try {
            System.setOut(new PrintStream(baos));
            Start.main(new String[] {"-v"});
        } finally {
            System.setOut(console);
        }
        assertEquals("RobotSimulator version 0.1\n", baos.toString());
    }

    @Test
    public void testHelp() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream console = System.out;
        try {
            System.setOut(new PrintStream(baos));
            Start.main(new String[] {"-h"});
        } finally {
            System.setOut(console);
        }
        assertTrue(baos.toString().contains("When using this RobotSimulator you have following options"));
    }
}
