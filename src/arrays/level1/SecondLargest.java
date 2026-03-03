package arrays.level1;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {5, 1, 8, 6};  // ans: 6

        int second = secondLargest(arr);
        System.out.println("Second Largest: " + second);
    }
    // Method to find second largest (distinct) element
    public static int secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int value : arr) {
            if (value > largest) {
                secondLargest = largest;
                largest = value;
            } else if (value > secondLargest && value != largest) {
                secondLargest = value;
            }
        }

        // Optional: agar distinct second largest nahi mila
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No distinct second largest element");
        }

        return secondLargest;
    }
}
