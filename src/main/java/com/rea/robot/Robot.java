package com.rea.robot;

public class Robot {
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
                positionY++;
                break;
            case SOUTH:
                positionY--;
                break;
            case WEST:
                positionX--;
                break;
            case EAST:
                positionX++;
                break;
        }
    }

    public void changeOrientation(Movement movement) {

    }
}
