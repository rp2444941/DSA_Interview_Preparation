package arrays.sliding_window;
import java.util.*;
public class MaxOfAllSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maxOfSubarrays(arr, k)); // [3, 3, 5, 5, 6, 7]
    }

    private static List<Integer> maxOfSubarrays(int[] arr, int k) {
        List<Integer> ans=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();// stores indices
        for (int i = 0; i <arr.length ; i++) {
            // remove indices out of current window
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            //Maintain decreasing deque
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.pollLast();
            }
            //add current index
            dq.offerLast(i);
            if(i>=k-1){
               Integer idx=dq.peekFirst();
               if(idx!=null){
                   ans.add(arr[idx]);

               }
            }

        }
        return ans;
    }
}
