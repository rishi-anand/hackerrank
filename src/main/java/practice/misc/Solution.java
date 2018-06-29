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
            areaCalculator.addRectangle(input2[i][0], input2[i][1], ((input2[i][2] - input2[i][0]) + 1), ((input2[i][3] - input2[i][1]) + 1));
        }

        System.out.println("result" + areaCalculator.calculate());

        return 0;
    }


    class Rectangle {
        private final Point topLeft;
        private final Point bottomRight;

        public Rectangle(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        public boolean isOverLapping(Rectangle other) {
            if (this.topLeft.x > other.bottomRight.x
                    || this.bottomRight.x < other.topLeft.x
                    || this.topLeft.y < other.bottomRight.y
                    || this.bottomRight.y > other.topLeft.y) {
                return false;
            }

            return true;
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}
