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

    public RobotCommand(String name, Integer positionX, Integer positionY, String orientation) {
        this(CommandName.valueOf(name.toUpperCase()),
                positionX,
                positionY,
                Orientation.valueOf(orientation.toUpperCase()));
    }

    public RobotCommand(String name) {
        this(CommandName.valueOf(name.toUpperCase()));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RobotCommand that = (RobotCommand) o;

        if (name != that.name) return false;
        if (orientation != that.orientation) return false;
        if (positionX != null ? !positionX.equals(that.positionX) : that.positionX != null) return false;
        if (positionY != null ? !positionY.equals(that.positionY) : that.positionY != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (positionX != null ? positionX.hashCode() : 0);
        result = 31 * result + (positionY != null ? positionY.hashCode() : 0);
        result = 31 * result + (orientation != null ? orientation.hashCode() : 0);
        return result;
    }
}
