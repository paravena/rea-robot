package com.rea.robot;

import org.apache.commons.cli.*;

import java.io.*;

public class Start {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("i", "in", true, "Input file");
        options.addOption("o", "out", true, "Output file");
        options.addOption("h", "help", false, "Help");
        options.addOption("v", "version", false, "Version");
        CommandLineParser parser = new DefaultParser();
        InputStream in = System.in;
        OutputStream out = System.out;
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("help")) {
                help(options);
                return;
            } else if (cmd.hasOption("version")) {
                version();
                return;
            } else {
                if (cmd.hasOption("in")) {
                    String inputFileName = cmd.getOptionValue("in");
                    in = new FileInputStream(inputFileName);
                }

                if (cmd.hasOption("out")) {
                    String outputFileName = cmd.getOptionValue("out");
                    out = new FileOutputStream(outputFileName);
                }
            }
        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace(System.out);
        }

        new RobotSimulator(out).readInput(in);
    }

    public static void help(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        String header = "When using this RobotSimulator you have following options\n\n";
        String footer = "\nPlease report any issue at http://github.com/paravena\n";
        formatter.printHelp("RobotSimulator", header, options, footer, true);
    }

    public static void version() {
        System.out.println("RobotSimulator version 0.1");
    }
}
