package com.company;

import java.util.Formatter;

public class Main {

    public static void main(String[] args) {

        Trip[] arrTrips = new Trip[10];
        arrTrips[0] = new StraightWay(1,2,1,2,100,1);
        arrTrips[1] = new StraightWay(10,5,15,2,13,1.25);
        arrTrips[2] = new StraightWay(1,2,-5,8,27,1);
        arrTrips[3] = new WayABC(1,2,-5,8,2,15,50,0.2);
        arrTrips[4] = new WayABC(2,-6,-11,8,2,90,70,0.2);
        arrTrips[5] = new WayABC(1,2,-5,8,6,1,70,0.2);
        arrTrips[6] = new StraightWay(1,6,-1,8,54,0);
        arrTrips[7] = new ArcWay(2,2,-5,8,6,23,2);
        arrTrips[8] = new StraightWay(-7,12,-5,8,56,1);
        arrTrips[9] = new ArcWay(2,2,-5,8,20,85,2);

        //Вывод исходного массива
        System.out.println("Исходный массив");
        printArr(arrTrips);

        Trip[] arrTrips2 = new Trip[10];

        // Копирование массива
        System.arraycopy(arrTrips,0,arrTrips2,0,10);

        // Сортировка массива по времени (по убыванию)
        sortByTime(arrTrips2);

        // Вывод сортированного массива
        System.out.println("\nОтсортированный массив");
        printArr(arrTrips2);

        // Поиск и вывод самой быстрой поездки
        System.out.println("\nСамая быстрая поездка");
        System.out.println(findMinTime(arrTrips2).toString());

        // Поиск наличия поездки в интервале 25 - 30 мин
        findByTime(arrTrips2, 25, 30);

    }

    // Метод сортировки
    public static void sortByTime(Trip[] trips){
        for(int i = trips.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( trips[j].calcTime() < trips[j+1].calcTime() ){
                    Trip tmp = trips[j];
                    trips[j] = trips[j+1];
                    trips[j+1] = tmp;
                }
            }
        }
    }

    // Метод поиска самой быстрой поездки
    public static Trip findMinTime(Trip[] trips){
        double min = Integer.MAX_VALUE;
        Trip minTrip = null;
        for (Trip t: trips
             ) {
            if(t.calcTime() < min){
                min = t.calcTime();
                minTrip = t;
            }
        }
        return minTrip;
    }

    // Метод вывода массива
    public static void printArr(Trip[] trips){
        for (Trip t: trips
             ) {
            System.out.println(t.toString());
        }
    }

    // Метод поиска поездок с длительность времени между заданными значениями в минутах
    public static void findByTime(Trip[] trips, double startmin, double endmin){
        double starthour = startmin/60;
        double endhour = endmin/60;
        int flag = 0;
        for (Trip t: trips
             ) {
            if(t.calcTime() >= starthour && t.calcTime() <= endhour){
                flag = 1;
            }
        }
        if(flag == 0) {
            System.out.println("Поездка не найдена");
        } else {
            System.out.println("Поездка найдена" );
        }
    }


}
