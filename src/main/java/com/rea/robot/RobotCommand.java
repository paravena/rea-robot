package com.rea.robot;

public class RobotCommand {
    private String name;
    private int positionX;
    private int positionY;
    private String orientation;

    public RobotCommand() {
    }

    public RobotCommand(String name) {
        this(name, 0, 0, null);
    }

    public RobotCommand(String name, int positionX, int positionY, String orientation) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "RobotCommand{" +
                "name='" + name + '\'' +
                '}';
    }
}
