package practice.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {

    public static void main(String[] args){
        int[][] a = {
                {1, 4, 4, 6, 1},
                {4, 3, 6, 6, 2},
                {2, 2, 5, 4, 3},
        };

        int[][] b = {
                {-3, 1, -1, 3, 1},
                {-1, 2, 2, 5, 2},
                {-2, -2, 1, 2, 3},
        };

        System.out.println(resolveconflict(b.length, b));
    }

    public static int resolveconflict(int input1, int[][] input2) {
        AreaCalculator areaCalculator = new AreaCalculator();
        for(int i = 0; i < input1; i++){
            areaCalculator.addParkingPlot(input2[i][0], input2[i][1], ((input2[i][2] - input2[i][0]) + 1), ((input2[i][3] - input2[i][1]) + 1), input2[i][4]);
        }
        return areaCalculator.calculate2();
    }
}

class AreaCalculator {
    private List<ParkingPlot> parkingPlots = new ArrayList<ParkingPlot>();
    private Map<String, Integer> unitPlotsPrice = new HashMap<String, Integer>();

    public void addParkingPlot(int x, int y, int width, int height, int price) {
        //System.out.println("x1:"+ x +", y1:"+ y + ", x2:"+(x + width)+", y2:"+ (y + height));
        parkingPlots.add(new ParkingPlot(x, y, width, height, price));
    }

    public int calculate2() {
        for (int parkingPlot = 0; parkingPlot < parkingPlots.size(); parkingPlot++) {
            calculate2(parkingPlots.get(parkingPlot), parkingPlot);
        }

        return price();
    }

    private int price(){
        int price = 0;
        for(Integer i : unitPlotsPrice.values()){
            price+= i;
        }

        return price;
    }

    private void calculate2(ParkingPlot currentParkingPlot, int currentCount) {
        for(int parkingPlot = 0; parkingPlot < parkingPlots.size(); parkingPlot++){
            if(parkingPlot != currentCount) {
                ParkingPlot overlap = currentParkingPlot.findOverlap(parkingPlots.get(parkingPlot));
                splitIntoUnits(overlap);
            }
        }
    }

    private void splitIntoUnits(ParkingPlot currentParkingPlot){
        for (int r = currentParkingPlot.x; r < currentParkingPlot.x + currentParkingPlot.width; r++) {
            for (int c = currentParkingPlot.y; c < currentParkingPlot.y + currentParkingPlot.height; c++) {
                String key = String.format("%d%d%d", r, c, currentParkingPlot.price);
                if(!unitPlotsPrice.containsKey(key)){
                    unitPlotsPrice.put(key, currentParkingPlot.price);
                }
            }
        }
    }
}

class ParkingPlot {
    public int price;
    public int x, y, width, height;

    public ParkingPlot(int x, int y, int width, int height, int price) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.price = price;
    }

    public int area() { return width * height; }

    public int price() { return area() * price; }

    public ParkingPlot findOverlap(ParkingPlot other) {
        int left = Math.max(this.x, other.x),
                right = Math.min(this.x + this.width, other.x + other.width),
                bottom = Math.max(this.y, other.y),
                top = Math.min(this.y + this.height, other.y + other.height),
                height = top - bottom,
                width = right - left;

        if (height > 0 && width > 0) //If both are positive, there is overlap.
            return new ParkingPlot(left, bottom, width, height, this.price);

        return null;
    }
}
