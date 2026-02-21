package arrays.level1;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 3, 7};

        // Edge case: empty array handle karo (optional, depends on question)
        if (arr.length == 0) {
            System.out.println("Array is empty, no largest element.");
            return;
        }

        int largest = arr[0]; // starting point

        // Single pass traversal
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i]; // update largest
            }
        }

        System.out.println("Largest element: " + largest);
    }
}


//for Each
//int largest = arr[0];
//for (int x : arr) {
//    if (x > largest) {
//        largest = x;
//    }
//}



//dry run Quick Dry Run Example
//Array: [5, 1, 9, 3, 7]
//
//Start: largest = 5
//i = 1 → arr[1] = 1 → 1 > 5? No → largest = 5
//i = 2 → arr[2] = 9 → 9 > 5? Yes → largest = 9
//i = 3 → arr[3] = 3 → 3 > 9? No → largest = 9
//i = 4 → arr[4] = 7 → 7 > 9? No → largest = 9
//Answer: 9