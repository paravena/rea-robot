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
        String pattern = "^(PLACE|MOVE|RIGHT|LEFT|REPORT)(\\s+?(\\d)\\s*?,\\s*?(\\d)\\s*?,\\s*?(NORTH|SOUTH|WEST|EAST))?$";
        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(line);

        RobotCommand robotCommand = null;
        if (matcher.find()) {
            robotCommand = new RobotCommand();
            String commandName = matcher.group(1).toUpperCase();
            robotCommand.setName(CommandName.valueOf(commandName));
            if ("PLACE".equals(commandName)) {
                Integer positionX = Integer.valueOf(matcher.group(3));
                Integer positionY = Integer.valueOf(matcher.group(4));
                if ((positionX < 0 || positionX > Robot.X_LIMIT)
                        || (positionY < 0 || positionY > Robot.Y_LIMIT)) {
                    return null;
                }
                robotCommand.setPositionX(positionX);
                robotCommand.setPositionY(positionY);
                robotCommand.setOrientation(Orientation.valueOf(matcher.group(5).toUpperCase()));
            }
        }
        return robotCommand;
    }
}
