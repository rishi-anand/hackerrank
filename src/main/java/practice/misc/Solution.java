package practice.misc;

public class Solution {

    public static void main(String[] args){
        int[][] a = {
                {1, 4, 4, 6, 1},
                {4, 3, 6, 6, 2},
                {2, 2, 5, 4, 3},
        };

        System.out.println(resolveconflict(3, a));
        //System.out.println(resolveconflict(3, a));
    }

    public static int resolveconflict(int input1,int[][] input2)
    {
        AreaCalculator areaCalculator = new AreaCalculator();

        for(int i = 0; i < input1; i++){
            areaCalculator.addRectangle(input2[i][0], input2[i][1], ((input2[i][2] - input2[i][0]) + 1), ((input2[i][3] - input2[i][1]) + 1), input2[i][4]);
        }

        System.out.println("result" + areaCalculator.calculate());

        return 0;
    }
}
