package com.rea.robot;

import java.io.OutputStream;
import java.io.PrintStream;

public class Robot {
    public static Integer X_LIMIT = 5;
    public static Integer Y_LIMIT = 5;
    private Integer positionX;
    private Integer positionY;
    private Orientation orientation;

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void move() {
        switch (orientation) {
            case NORTH:
                if (positionY < Y_LIMIT) {
                    positionY++;
                }
                break;
            case SOUTH:
                if (positionY > 0) {
                    positionY--;
                }
                break;
            case WEST:
                if (positionX > 0) {
                    positionX--;
                }
                break;
            case EAST:
                if (positionX < X_LIMIT) {
                    positionX++;
                }
                break;
        }
    }

    public void changeOrientation(CommandName movement) {
        switch (orientation) {
            case NORTH:
                if (CommandName.LEFT.equals(movement)) {
                    orientation = Orientation.WEST;
                } else {
                    orientation = Orientation.EAST;
                }
                break;
            case SOUTH:
                if (CommandName.LEFT.equals(movement)) {
                    orientation = Orientation.EAST;
                } else {
                    orientation = Orientation.WEST;
                }
                break;
            case WEST:
                if (CommandName.LEFT.equals(movement)) {
                    orientation = Orientation.SOUTH;
                } else {
                    orientation = Orientation.NORTH;
                }
                break;
            case EAST:
                if (CommandName.LEFT.equals(movement)) {
                    orientation = Orientation.NORTH;
                } else {
                    orientation = Orientation.SOUTH;
                }
                break;
        }
    }

    public void report(OutputStream out) {
        new PrintStream(out).println(positionX + "," + positionY + "," + orientation);
    }
}
