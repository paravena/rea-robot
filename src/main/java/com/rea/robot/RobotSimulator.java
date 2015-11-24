package com.rea.robot;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class RobotSimulator {
    protected Robot robot;
    protected RobotCommandValidator robotCommandValidator;
    protected OutputStream out;

    public RobotSimulator(OutputStream out) {
        robot = new Robot();
        robotCommandValidator = RobotCommandValidator.getInstance();
        this.out = out;
    }

    public void readInput(InputStream in) {
        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            RobotCommand command = robotCommandValidator.validateCommand(line);
            if (command != null) {
                processCommand(command);
            }
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
                robot.report(out);
            }
        }
    }

    private boolean isRobotInitialized() {
        return robot.getPositionX() != null && robot.getPositionY() != null && robot.getOrientation() !=null;
    }
}
