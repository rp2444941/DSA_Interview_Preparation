package arrays.Stack_Monotonic_Stack;

import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};

        int[] brute = nextGreaterBrute(arr);
        int[] optimal = nextGreaterOptimal(arr);
        System.out.println("Array   : " + Arrays.toString(arr));
        System.out.println("Brute   : " + Arrays.toString(brute));
        System.out.println("Optimal : " + Arrays.toString(optimal));
    }
    public static int[] nextGreaterBrute(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }

        return ans;
    }

    public static int[] nextGreaterOptimal(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        return ans;
    }

}
