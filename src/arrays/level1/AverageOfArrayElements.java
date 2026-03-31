package arrays.level1;

public class AverageOfArrayElements {
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, -3, 7};

        if (arr.length == 0) {
            System.out.println("Array is empty, average not defined.");
            return;
        }

        int sum = 0;


        // Single pass traversal to compute sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // Cast to double for correct decimal average
        double average = (double) sum / arr.length;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }

}
