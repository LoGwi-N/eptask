package com.company;

import java.util.Formatter;

public class StraightWay extends Trip {

    StraightWay(int A_X, int A_Y, int B_X, int B_Y, int spd, double stop){
            pointA_X = A_X;
            pointA_Y = A_Y;
            pointB_X = B_X;
            pointB_Y = B_Y;
            speed = spd;
            timeForStop = stop;
    }

    public double distance(){
        return Math.sqrt(Math.pow((pointB_X - pointA_X),2)+Math.pow((pointB_Y - pointA_Y),2));
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
        return "Прямой путь: " + "A(" + pointA_X + ";" + pointA_Y + ") B(" + pointB_X + ";" + pointB_Y + ") Скорость: " + speed + " км/ч" +
                " Остановка: " + timeForStop + " ч  Время поездки: " + (formatter.format("%.3f", calcTime())) + " ч  Расстояние: " +
                    (formatter2.format("%.3f", distance())) + " км";
    }
}
