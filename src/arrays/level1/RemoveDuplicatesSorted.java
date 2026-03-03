package arrays.level1;

public class RemoveDuplicatesSorted {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4, 4};

        int newLength = removeDuplicatesInPlace(arr);

        // Sirf first newLength elements print karo
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
        // Output: 1 2 3 4
    }

    // returns: length of array after removing duplicates
    public static int removeDuplicatesInPlace(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int j = 1; // next position for unique element

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) { // naya unique mila
                arr[j] = arr[i];
                j++;
            }
        }

        return j; // j = unique elements count
    }
}
