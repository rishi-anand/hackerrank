package thirty.days.of.code.twentyone;

public class Printer<T> {

    public void printArray(T[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
