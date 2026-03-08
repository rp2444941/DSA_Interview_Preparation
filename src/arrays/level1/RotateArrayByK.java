package arrays.level1;

public class RotateArrayByK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotateRightByK(arr, k);

        // Print rotated array
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 5 6 7 1 2 3 4
    }
    public static void rotateRightByK(int[] arr, int k){
        if(arr==null || arr.length==0) return;

        int n= arr.length;
        // Normalize k (in case k > n)
        k=k%n;
        if(k==0){
            return;// rotation by 0 or multiple of n gives same array
        }
        // Step 1: Reverse entire array
        reverse(arr,0,n-1);
        // Step 2: Reverse first k elements
        reverse(arr,0,k-1);
        // Step 3: Reverse remaining n - k elements
        reverse(arr,0,n-1);

    }
    // Helper method to reverse part of array from index start to end
    public static void reverse(int[] arr, int start, int end){
        while(start<end){
            // swap arr[start] and arr[end]
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

}
