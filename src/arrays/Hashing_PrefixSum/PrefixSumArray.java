package arrays.Hashing_PrefixSum;
import java.util.*;
public class PrefixSumArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 3};
        System.out.println(Arrays.toString(prefixSum(arr)));

        System.out.println(Arrays.toString(prefixSumOptimal(arr)));
    }

    private static int[] prefixSumOptimal(int[] arr) {
        int n= arr.length;
        int[] prefix=new int[n];
        prefix[0]=arr[0];
        for (int i = 1; i <n ; i++) {
            prefix[i]=prefix[i-1]+arr[i];

        }
        return prefix;
    }

    private static int[] prefixSum(int[] arr) {
        int n= arr.length;
        int[] prefix=new int[n];
        for (int i = 0; i <n ; i++) {
            int sum=0;
            for (int j = 0; j <=i ; j++) {
                sum+=arr[j];

            }
            prefix[i]=sum;

        }
        return prefix;
    }
}
