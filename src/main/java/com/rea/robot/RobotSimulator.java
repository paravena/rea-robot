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

        if (CommandName.PLACE.equals(robotCommand.getName())) {
            robot.setPositionX(robotCommand.getPositionX());
            robot.setPositionY(robotCommand.getPositionY());
            robot.setOrientation(robotCommand.getOrientation());
        } else if (isRobotInitialized()) {
            if (CommandName.MOVE.equals(robotCommand.getName())) {
                robot.move();
            } else if (CommandName.LEFT.equals(robotCommand.getName())) {
                robot.changeOrientation(CommandName.LEFT);
            } else if (CommandName.RIGHT.equals(robotCommand.getName())) {
                robot.changeOrientation(CommandName.RIGHT);
            } else if (CommandName.REPORT.equals(robotCommand.getName())) {
                robot.report(System.out);
            }
        }
    }

    private boolean isRobotInitialized() {
        return robot.getPositionX() != null && robot.getPositionY() != null && robot.getOrientation() !=null;
    }
}
