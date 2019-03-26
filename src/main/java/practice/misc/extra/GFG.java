package practice.misc.extra;

import java.util.ArrayList;
import java.util.List;

class GFG
{
    public static String getStringLookAndSayValue(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
    }

    private static int getSum(String input){
        char[] inputCharArray = input.toCharArray();
        int sum = 0;
        for(char c : inputCharArray){
            sum += Integer.valueOf(String.valueOf(c));
        }

        return sum;
    }

    public static List<Integer> lookAndSayQueries(List<Integer> q) {
        List<Integer> integers = new ArrayList<>();
        q.stream().forEach(i -> integers.add(getSum(getStringLookAndSayValue(i))));
        return integers;
    }

    public static void main(String[] args) {
        int N = 3;
        //System.out.println(getSum(getStringLookAndSayValue(900)));

        System.out.println(getStringLookAndSayValue(2));
    }
}

// This code is contributed
// by ChitraNayal