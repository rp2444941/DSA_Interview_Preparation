package arrays.sliding_window;
import java.util.*;

public class FirstNegativeInWindow {
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15};
        int k = 3;
        System.out.println(firstNegative(arr, k)); // [-1, -7, -15]
    }

    private static List<Integer> firstNegative(int[] arr, int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>(); // stores indices of negative elements
        for (int i = 0; i < arr.length ; i++) {
            //add current negative index
            if(arr[i]<0){
                q.offer(i);
            }
            // remove indices out of current window
            while(!q.isEmpty() && q.peek()<=i-k){
                q.poll();
            }
            //start recording answers when first window is formed
            if(i>=k-1){
                if(q.isEmpty()){
                    ans.add(0);
                }else{
                    ans.add(arr[q.peek()]);
                }
            }

        }
        return ans;
    }
}
