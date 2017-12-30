package util;

public class MathUtil {

    public static long getLcm(int[] input){
        long lcm = input[0];
        if(input.length > 1) {
            for (int i = 1; i < input.length; i++) {
                lcm = getLcm(input[i], lcm);
            }
        }

        return lcm;
    }

    public static long getLcm(long a, long b){
        return (a * b) / Long.valueOf(getGcd(a, b));
    }

    public static long getGcd(int[] input){
        long gcd = input[0];
        if(input.length > 1) {
            for (int i = 1; i < input.length; i++) {
                gcd = getGcd(gcd, input[i]);
            }
        }

        return gcd;
    }


    public static long getGcd(long a, long b){
        if(b > a){
            long c = b;
            b = a;
            a = c;
        }

        if(b == 0){
            return a;
        }

        if(a == 0){
            return b;
        }

        return getGcd(a % b, b);
    }
}
