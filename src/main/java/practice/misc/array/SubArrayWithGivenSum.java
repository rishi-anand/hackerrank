package practice.misc.array;

/*

https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

*/
public class SubArrayWithGivenSum {

    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 7, 5};
        int sum1= 12;
        getIndexWithSum(arr1, sum1);

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum2= 15;
        subArraySum(arr2, arr2.length, sum2);
    }

    private static void getIndexWithSum(int[] arr, int sum){
        int startingIndex = 0;
        boolean iterate = true;
        int currentSum = 0;

        while (iterate) { // will go to k elements untill sum is matched
            for (int i = startingIndex; i < arr.length; i++) { // will go for n times
                currentSum += arr[i];
                if(currentSum == sum){
                    iterate = false;
                    System.out.println("Sum found between indexes " + startingIndex
                            + " and " + i);
                    break;
                } else if(currentSum > sum){
                    currentSum = 0;
                    startingIndex++;
                    break;
                }
            }
        }
    }

    static int subArraySum(int arr[], int n, int sum) {
        int curr_sum = arr[0], start = 0, i;
        for (i = 1; i <= n; i++) {
            while (curr_sum > sum && start < i-1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            if (curr_sum == sum) {
                int p = i-1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
                return 1;
            }

            if (i < n)
                curr_sum = curr_sum + arr[i];
        }

        System.out.println("No subarray found");
        return 0;
    }
}
