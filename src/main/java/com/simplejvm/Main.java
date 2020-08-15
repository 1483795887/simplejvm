package com.simplejvm;

import org.apache.commons.cli.*;
import sun.java2d.marlin.Version;

public class Main {

    private static final String VERSION = "1.0";

    public static void main(String[] args) {
        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("version", "", false, "print version and exit");

        options.addOption("help", "", false, "print help message");

        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
            if(cmd.hasOption("h")){
                formatter.printHelp("Usage [-options] class [args...]",options);
            }
            else if (cmd.hasOption("v")){
                System.out.println(VERSION);
            }

            for(String arg : cmd.getArgs()){
                System.out.println(arg);
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Usage [-option] class [args...]", options);
            System.exit(1);
        }
    }
}
