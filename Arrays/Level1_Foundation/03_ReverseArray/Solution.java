//Two Pointer / In-place swapping

public class Solution {

    // Method to reverse array using two pointers
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers
            left++;
            right--;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original Array:");
        printArray(arr);

        reverseArray(arr);

        System.out.println("Reversed Array:");
        printArray(arr);
    }

    // Helper method to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}