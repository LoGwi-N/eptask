package com.company;

public abstract class Trip {

    protected int pointA_X;
    protected int pointA_Y;
    protected int pointB_X;
    protected int pointB_Y;
    protected int speed;
    protected double timeForStop;

    public abstract double distance();
    public abstract double calcTime();

}
