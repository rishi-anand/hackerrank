package practice.misc.array;

public class MissingNumberInArray {

    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 5};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        int missing = getMissingNumber(arr2, 0, arr2[arr2.length - 1]);

        System.out.println(missing);
    }

    private static int getMissingNumber(int[] arr, int low, int high){

        int mid = ((low + high) % 2 == 0) ? ((low + high) / 2) : ((low + high + 1) / 2);

        if(arr[mid] - mid > 1){
            return --arr[mid];
        }

        if(arr[mid] == (mid) + 1){
            //This means number is missing in right half
            return getMissingNumber(arr, mid, high);
        } else {
            return getMissingNumber(arr, low, mid);
        }
    }
}
