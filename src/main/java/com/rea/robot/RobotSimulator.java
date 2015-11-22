package com.rea.robot;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotSimulator {
    public void readInput(InputStream in) {
        String line;
        Scanner scan = new Scanner(in);
        while ((line = scan.nextLine()) != null) {
            RobotCommand command = validateCommand(line);
        }
    }

    private RobotCommand validateCommand(String line) {
        String pattern = "^(PLACE|MOVE|RIGHT|LEFT)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(line);
        if (matcher.find()) {

        }
        return null;
    }
}
