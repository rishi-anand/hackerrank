package practice.misc.array;

public class SubArrayWithMaxSum {

    public static void main(String[] args){
        int[] arr = {1, 2, 3, -2, 5};

        int[] arr1 = {-1, -2, -3, -4};
        System.out.println(getMaxSubArraySum(arr1));
    }

    public static int getMaxSubArraySum(int[] arr){
        int max_so_far = arr[0];
        int current_max = arr[0];

        for(int i = 1; i < arr.length; i++){
            current_max = Math.max(arr[i], current_max + arr[i]);
            max_so_far = Math.max(max_so_far, current_max);
        }

        return max_so_far;
    }
}