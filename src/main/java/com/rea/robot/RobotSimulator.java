package com.rea.robot;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotSimulator {
    private Robot robot;

    public RobotSimulator() {
        this.robot = new Robot();
    }

    public void readInput(InputStream in) {
        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            RobotCommand command = validateCommand(line);
        }
    }

    private RobotCommand validateCommand(String line) {
        String pattern = "^(PLACE|MOVE|RIGHT|LEFT|REPORT)\\s+?(\\d)\\s*?,\\s*?(\\d)\\s*?,\\s*?(NORTH|SOUTH|WEST|EAST)$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(line);

        RobotCommand robotCommand = null;
        if (matcher.find()) {
            robotCommand = new RobotCommand();
            String commandName = matcher.group(1);
            robotCommand.setName(commandName);
            if ("PLACE".equals(commandName)) {
                robotCommand.setPositionX(Integer.valueOf(matcher.group(2)));
                robotCommand.setPositionY(Integer.valueOf(matcher.group(3)));
                robotCommand.setOrientation(matcher.group(4));
            }
        }
        return robotCommand;
    }

    public void processCommand(RobotCommand robotCommand) {
        if ("PLACE".equals(robotCommand.getName())) {
            robot.setPositionX(robotCommand.getPositionX());
            robot.setPositionY(robotCommand.getPositionY());
            robot.setOrientation(robotCommand.getOrientation());
        } else if ("MOVE".equals(robotCommand.getName())) {

        } else if ("LEFT".equals(robotCommand.getName())) {

        } else if ("RIGHT".equals(robotCommand.getName())) {

        } else if ("REPORT".equals(robotCommand.getName())) {

        }
    }
}
