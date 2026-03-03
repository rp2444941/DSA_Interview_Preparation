package arrays.level1;

public class CheckSorted {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};      // sorted
        int[] arr2 = {5, 3, 4, 6};      // not sorted

        System.out.println(isSortedAscending(arr1)); // true
        System.out.println(isSortedAscending(arr2)); // false
    }

    private static boolean isSortedAscending(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true; // 0 or 1 element -> already sorted
        }
        for (int i = 0; i < arr.length-1 ; i++) {
            if(arr[i]>arr[i+1]){
                return false;
            }

        }
        return true;
    }
}
