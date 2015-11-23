package com.rea.robot;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotSimulator {
    private Robot robot;
    private RobotCommandValidator robotCommandValidator;

    public RobotSimulator() {
        robot = new Robot();
        robotCommandValidator = RobotCommandValidator.getInstance();
    }

    public void readInput(InputStream in) {
        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            RobotCommand command = robotCommandValidator.validateCommand(line);
        }
    }

    public void processCommand(RobotCommand robotCommand) {

        if ("PLACE".equals(robotCommand.getName())) {
            robot.setPositionX(robotCommand.getPositionX());
            robot.setPositionY(robotCommand.getPositionY());
            robot.setOrientation(robotCommand.getOrientation());
        } else if (isRobotInitialized()) {
            if ("MOVE".equals(robotCommand.getName())) {
                robot.move();
            } else if ("LEFT".equals(robotCommand.getName())) {
                robot.changeOrientation(Movement.LEFT);
            } else if ("RIGHT".equals(robotCommand.getName())) {
                robot.changeOrientation(Movement.RIGHT);
            } else if ("REPORT".equals(robotCommand.getName())) {

            }
        }
    }

    private boolean isRobotInitialized() {
        return robot.getPositionX() != null && robot.getPositionY() != null && robot.getOrientation() !=null;
    }
}
