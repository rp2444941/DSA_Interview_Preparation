package arrays.level1;

public class SumOfArrayElements {
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, -3, 7};

        int sum = 0; // starting sum

        // Single pass traversal
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];  // sum = sum + arr[i];
        }

        System.out.println("Sum of all elements: " + sum);
    }
}
