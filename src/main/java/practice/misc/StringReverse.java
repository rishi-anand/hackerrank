package practice.misc;

public class StringReverse {

    public static void main(String[] args) throws Exception {
        int[] arr = {1, 20, 3};
        int res = getMaximumSum(arr);
        System.out.println(res);

        char ch = 'P';
        int asciiCode = ch;
        // type casting char as int
        int asciiValue = (int)ch;

        System.out.println("ASCII value of "+ch+" is: " + asciiCode);
        System.out.println("ASCII value of "+ch+" is: " + asciiValue);
    }

    public static int fib(int n){
        return	n <= 1 ? n : fib(n-1) + fib(n-2);
    }

    public static void printMatrix(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j<= n; j++){
                System.out.print(i * j + "   ");
            }

            System.out.println();
        }
    }

    private static int getMaximumSum(int[] arr){
        int inclusive = 0;
        int exclusive = 0;

        for (int i = 0; i < arr.length; i++){
            if(i % 2 == 0){
                exclusive += arr[i];
            } else {
                inclusive += arr[i];
            }
        }

        return Math.max(inclusive, exclusive);
    }
}
