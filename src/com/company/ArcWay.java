package com.company;

import java.util.Formatter;

public class ArcWay extends Trip {

    private double radius;

    ArcWay(int A_X, int A_Y, int B_X, int B_Y, double rad, int spd, double stop){
        pointA_X = A_X;
        pointA_Y = A_Y;
        pointB_X = B_X;
        pointB_Y = B_Y;
        radius = rad;
        speed = spd;
        timeForStop = stop;
    }

    public double distance(){
        double chord = Math.sqrt(Math.pow((pointB_X - pointA_X),2)+Math.pow((pointB_Y - pointA_Y),2));
        if(radius >= chord/2){
            double a = Math.toDegrees(Math.asin((chord/2)/radius));
            double l = Math.PI*radius*a*2/180;
            return l;
        } else{
            System.out.println("Ошибка, введите значение радиуса больше (R > Chord/2)");
        }
        return 0;
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
        return "По дуге: " + "A(" + pointA_X + ";" + pointA_Y + ") B(" + pointB_X + ";" + pointB_Y + ") Радиус дуги: " + radius + " Скорость: " + speed + " км/ч" +
                " Остановка: " + timeForStop + " ч  Время поездки: " + (formatter.format("%.3f", calcTime())) + " ч  Расстояние: " +
                (formatter2.format("%.3f", distance())) + " км";
    }

}
