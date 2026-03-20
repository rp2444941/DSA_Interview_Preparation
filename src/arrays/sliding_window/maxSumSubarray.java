package arrays.sliding_window;

public class maxSumSubarray {
    public static void main(String[] args) {
        int[] arr = {2,1,5,1,3,2};
        int k = 3;

        int result = maxSum(arr, k);
        System.out.println("Maximum Sum: " + result);
    }

    private static int maxSum(int[] arr, int k) {
        if(arr.length<k){
            return -1;
        }
        int ws=0;
        // frist window
        for(int i=0;i<k;i++){
            ws+=arr[i];
        }
        int ms=ws;
        // sliding window
        for(int i=k;i< arr.length;i++){
            ws=ws-arr[i-k]+arr[i];
            ms=Math.max(ms,ws);
        }
       return ms;
    }

}
