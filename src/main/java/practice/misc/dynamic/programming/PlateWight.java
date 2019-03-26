package practice.misc.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class PlateWight {

    private static Map<Integer, Integer> plateMap = new HashMap<>();
    private static int[][] memoizationWeightMatrix;

    static {
        plateMap.put(1, 1);
        plateMap.put(2, 3);
        plateMap.put(3, 5);
    }

    private static int getWeightOfPlates(){
        int maxCapacity = 7;
        memoizationWeightMatrix = new int[plateMap.keySet().size() + 1][maxCapacity + 1];
        for(int i = 0; i <= plateMap.keySet().size(); i++){
            for(int j = 0; j <= maxCapacity; j++){
                if(i == 0 || j == 0){
                    memoizationWeightMatrix[i][j] = 0;
                } else if (plateMap.get(i) > j) {
                    memoizationWeightMatrix[i][j] = memoizationWeightMatrix[i - 1][j];
                } else if(plateMap.get(i) == j){
                    memoizationWeightMatrix[i][j] = Math.max(memoizationWeightMatrix[i - 1][j], plateMap.get(i));
                } else {
                    Map<Integer, Integer> plateCountMap = new HashMap<>();
                    for(int p = i; p > 0; p--){
                        plateCountMap.put(plateMap.get(p), 1);
                    }

                    int totalWeightWithNewPlate = 0;
                    totalWeightWithNewPlate = totalWeightWithNewPlate + memoizationWeightMatrix[i][j - plateMap.get(i)];
                    memoizationWeightMatrix[i][j] = Math.max(memoizationWeightMatrix[i - 1][j], totalWeightWithNewPlate);
                }
            }
        }

        System.out.println(memoizationWeightMatrix[plateMap.keySet().size()][maxCapacity]);

        return 0;

    }

    public static void main(String[] args){
        getWeightOfPlates();
    }
}
