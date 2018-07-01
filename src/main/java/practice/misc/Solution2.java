package practice.misc;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    private static Map<String, Integer> unitPlotsPrice = new HashMap<String, Integer>();

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
        for(int i = 0; i < input1; i++){
            calculate(i, input1, input2);
        }
        return price();
    }


    private static void calculate(int currentCount, int total, int[][] input2) {
        for(int parkingPlot = 0; parkingPlot < total; parkingPlot++){
            if(parkingPlot != currentCount) {
                calculateOverlap(
                        input2[currentCount][0],
                        input2[currentCount][1],
                        ((input2[currentCount][2] - input2[currentCount][0]) + 1),
                        ((input2[currentCount][3] - input2[currentCount][1]) + 1),
                        input2[currentCount][4],

                        input2[parkingPlot][0],
                        input2[parkingPlot][1],
                        ((input2[parkingPlot][2] - input2[parkingPlot][0]) + 1),
                        ((input2[parkingPlot][3] - input2[parkingPlot][1]) + 1)
                );
            }
        }
    }


    //Below code calculates rectange overlap
    public static void calculateOverlap(int fx, int fy, int fwidth, int fheight, int fprice, int sx, int sy, int swidth, int sheight) {
        int left = Math.max(fx, sx),
                right = Math.min(fx + fwidth, sx + swidth),
                bottom = Math.max(fy, sy),
                top = Math.min(fy + fheight, sy + sheight),
                height = top - bottom,
                width = right - left;

        if (height > 0 && width > 0) { //If both are positive, there is overlap.
            //return new ParkingPlot(left, bottom, width, height, fprice);
            for (int r = left; r < left + width; r++) {
                for (int c = bottom; c < bottom + height; c++) {
                    String key = String.format("%d%d%d", r, c, fprice);
                    if(!unitPlotsPrice.containsKey(key)){
                        unitPlotsPrice.put(key, fprice);
                    }
                }
            }
        }
    }


    private static int price(){
        int price = 0;
        for(Integer i : unitPlotsPrice.values()){
            price+= i;
        }
        return price;
    }

}
