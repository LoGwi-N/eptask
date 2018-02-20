package com.company;

import java.util.Formatter;

public class WayABC extends Trip {

    private int pointC_X;
    private int pointC_Y;

    WayABC(int A_X, int A_Y, int B_X, int B_Y, int C_X, int C_Y, int spd, double stop){
        pointA_X = A_X;
        pointA_Y = A_Y;
        pointB_X = B_X;
        pointB_Y = B_Y;
        pointC_X = C_X;
        pointC_Y = C_Y;
        speed = spd;
        timeForStop = stop;
    }

    public double distance(){
        double AC = Math.sqrt(Math.pow((pointC_X - pointA_X),2)+Math.pow((pointC_Y - pointA_Y),2));
        double CB = Math.sqrt(Math.pow((pointB_X - pointC_X),2)+Math.pow((pointB_Y - pointC_Y),2));
        return AC + CB;
    }

    public double calcTime(){
        double time;
        if(timeForStop > 0){
            return time = distance()/speed + timeForStop;
        } else{
            return time = distance()/speed;
        }
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        Formatter formatter2 = new Formatter();
        return "Путь через C: " + "A(" + pointA_X + ";" + pointA_Y + ") B(" + pointB_X + ";" + pointB_Y + ") C(" + pointC_X + ";" + pointC_Y + ") Скорость: " + speed + " км/ч" +
                " Остановка: " + timeForStop + " ч  Время поездки: " + (formatter.format("%.3f", calcTime())) + " ч  Расстояние: " +
                (formatter2.format("%.3f", distance())) + " км";
    }
}
