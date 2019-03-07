package geeks.fr.geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {


    public static int reductionCost(List<Integer> num) {
        int sum = 0;
        Collections.sort(num);
        while (!num.isEmpty()){
            int a = num.remove(0);
            if(!num.isEmpty()){
                int b = num.remove(0);
                int x = a + b;
                sum += x;
                if(!num.isEmpty()) {
                    num.add(x);
                    Collections.sort(num);
                }
            } else {
                sum += a;
            }
        }

        return sum;
    }

    public static void main(String[] args){
        List<Integer> integers = new ArrayList<Integer>();
        //integers.add(3);
        integers.add(1);
        integers.add(2);
        integers.add(3);

        System.out.println(reductionCost(integers));
    }
}
