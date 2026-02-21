package arrays.level1;

public class SmallestElement {
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, -3, 7};

        // Edge case: empty array
        if (arr.length == 0) {
            System.out.println("Array is empty, no smallest element.");
            return;
        }

        int smallest = arr[0]; // starting with first element

        // Single pass traversal
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {   // opposite of largest
                smallest = arr[i];     // update smallest
            }
        }

        System.out.println("Smallest element: " + smallest);
    }
}
