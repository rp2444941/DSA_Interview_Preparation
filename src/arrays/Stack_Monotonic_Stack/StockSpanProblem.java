package arrays.Stack_Monotonic_Stack;
import java.util.*;

public class StockSpanProblem {

    public static int[] stockSpanBrute(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (prices[j] <= prices[i]) {
                    count++;
                } else {
                    break;
                }
            }

            span[i] = count;
        }

        return span;
    }

    public static int[] stockSpanOptimal(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }

            st.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] brute = stockSpanBrute(prices);
        int[] optimal = stockSpanOptimal(prices);

        System.out.println("Prices  : " + Arrays.toString(prices));
        System.out.println("Brute   : " + Arrays.toString(brute));
        System.out.println("Optimal : " + Arrays.toString(optimal));
    }
}