package com.rea.robot;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.*;

public class Start {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("in", true, "Input file");
        options.addOption("out", true, "Output file");
        CommandLineParser parser = new DefaultParser();
        InputStream in = System.in;
        OutputStream out = System.out;

        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("in")) {
                String inputFileName = cmd.getOptionValue("in");
                in = new FileInputStream(inputFileName);
            }

            if (cmd.hasOption("out")) {
                String outputFileName = cmd.getOptionValue("out");
                out = new FileOutputStream(outputFileName);
            }
        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace(System.out);
        }

        new RobotSimulator(out).readInput(in);
    }
}
