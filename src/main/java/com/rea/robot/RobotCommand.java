package com.rea.robot;

public class RobotCommand {
    private CommandName name;
    private Integer positionX;
    private Integer positionY;
    private Orientation orientation;

    public RobotCommand() {
    }

    public RobotCommand(CommandName name) {
        this(name, 0, 0, null);
    }

    public RobotCommand(CommandName name, Integer positionX, Integer positionY, Orientation orientation) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public CommandName getName() {
        return name;
    }

    public void setName(CommandName name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return name.toString();
    }
}
