package arrays.Hashing_PrefixSum;

public class CountSubarraysSumK {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        System.out.println(countSubarrays(arr, k));
    }

    private static int countSubarrays(int[] arr, int k) {
        int n=arr.length;
        int count=0;
        for (int i = 0; i <n ; i++) {
            int sum=0;
            for (int j = i; j < n; j++) {
                sum+=arr[j];
                if(sum==k) count++;

            }

        }
        return count;
    }
}
