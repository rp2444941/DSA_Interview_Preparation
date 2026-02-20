public class Solution {
    public static void main(String[] args) {
        // Example array
        int[] arr = {5, 2, 8, 1, 9};

        // Find smallest element
        int smallest = findSmallest(arr);
        System.out.println("Smallest element: " + smallest);
    }

    public static int findSmallest(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}