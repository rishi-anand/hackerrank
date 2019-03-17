package practice.misc.dynamic.programming;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class CuttingRope {

    private static Map<Integer, Integer> priceMap = new HashMap<>();
    private static int[][] memoizationMatrix;

    static {
        priceMap.put(1, 1);
        priceMap.put(2, 5);
        priceMap.put(3, 8);
        priceMap.put(4, 9);
        priceMap.put(5, 10);
        priceMap.put(6, 17);
        priceMap.put(7, 17);
        priceMap.put(8, 20);
    }

    public static void main(String[] args){
        int rodLength = 8;
        memoizationMatrix = new int[rodLength + 1][rodLength + 1];
        for(int i = 0; i <= rodLength; i++){
            for(int j = 0; j <= rodLength; j++){
                if(i == 0 || j == 0){
                    memoizationMatrix[i][j] = 0;
                } else {
                    //When i > j then this means one cell above value will come at that place
                    if(i > j){
                        memoizationMatrix[i][j] = memoizationMatrix[i - 1][j];
                    } else {
                        memoizationMatrix[i][j] = Math.max(
                                memoizationMatrix[i - 1][j], (priceMap.get(i) + memoizationMatrix[i][j - i])
                        );
                    }
                }
            }
        }

        System.out.println(new Gson().toJson(memoizationMatrix));

    }
}
