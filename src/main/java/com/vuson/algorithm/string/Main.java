package vu.son.algorithm.string;

import java.util.ArrayList;
import java.util.List;

class Main { // the class for a moving average

    // constructor
    int size ;

    List<Double> list = new ArrayList();

    public Main(int size) {
        this.size = size;
    }

    // add
    public synchronized void addValue(double x) {
        list.add(x);
    }

    // get

    public synchronized double getMovingAverage() {
        double result ;
        if(list.size() == 0) return 0;
        if(list.size()>=size) {
            double tempSum = 0.0;
            for(int i=list.size()-size;i<list.size();i++) {
                tempSum += list.get(i);
            }
            result = tempSum / size;
        } else {
            double tempSum = 0.0;
            for(int i=0;i<list.size();i++) {
                tempSum += list.get(i);
            }
            result = tempSum / size;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] windowSizes = {1,2,3,10000000};
        for (int windowSize : windowSizes) {
            System.out.println("\nN=" + windowSize);
            double[] input = {1,2,3,7,5};
            var sol = new Main(windowSize);
            System.out.println(sol.getMovingAverage());
            for(double x: input){
                sol.addValue(x);
                System.out.println(sol.getMovingAverage());
            }
        }
        System.out.println("\n\nDone!");
    }
}