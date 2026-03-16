package arrays.level2;
import java.util.*;
public class MinSwapsSort {
    static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        int[] arr={1,5,4,3,2};
        System.out.println(minSwaps(arr));
    }
    public static int minSwaps(int[] arr){
        int n= arr.length;
        Pair[] pairs=new Pair[n];
        for (int i = 0; i <n ; i++) {
            pairs[i]=new Pair(arr[i],i );

        }
        Arrays.sort(pairs,Comparator.comparingInt(p->p.value));

        boolean[] visited=new boolean[n];
        int swaps=0;
        for (int i = 0; i <n ; i++) {
            if(visited[i] || pairs[i].index==i)
                continue;
            int cycleSize=0;
            int j=i;
             while(!visited[j]){
                 visited[j]=true;
                 j=pairs[j].index;
                 cycleSize++;
             }
             if(cycleSize>0)
                 swaps+=(cycleSize-1);

        }
        return swaps;

    }
}
