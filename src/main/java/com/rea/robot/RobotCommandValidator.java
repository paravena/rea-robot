package com.rea.robot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotCommandValidator {
    private static RobotCommandValidator instance;

    private RobotCommandValidator() {
    }

    public static RobotCommandValidator getInstance() {
        if (instance == null) {
            instance = new RobotCommandValidator();
        }
        return instance;
    }

    public RobotCommand validateCommand(String line) {
        String pattern = "^(PLACE|MOVE|RIGHT|LEFT|REPORT)\\s+?(\\d)\\s*?,\\s*?(\\d)\\s*?,\\s*?(NORTH|SOUTH|WEST|EAST)$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(line);

        RobotCommand robotCommand = null;
        if (matcher.find()) {
            robotCommand = new RobotCommand();
            String commandName = matcher.group(1);
            robotCommand.setName(CommandName.valueOf(commandName));
            if ("PLACE".equals(commandName)) {
                robotCommand.setPositionX(Integer.valueOf(matcher.group(2)));
                robotCommand.setPositionY(Integer.valueOf(matcher.group(3)));
                robotCommand.setOrientation(Orientation.valueOf(matcher.group(4)));
            }
        }
        return robotCommand;
    }
}
