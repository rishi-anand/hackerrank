package practice.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StringReverse {

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//        BufferedReader in = new BufferedReader ( new FileReader( "" ));
//
//        Stream<String> stream = in.lines();
//
//
//        in.lines().flatMapToInt(x -> IntStream.of(Integer.parseInt(x)));
//
//        printMatrix(input);


        String host = "http://10.0.0.0";
        Pattern ipPattern= Pattern.compile("(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}");
        if(ipPattern.matcher(host).matches()){
            System.out.println("ipBased");
        } else {
            System.out.println("dnsBased");
        }



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
}
