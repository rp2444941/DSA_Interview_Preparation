package arrays.Hashing_PrefixSum;

import java.util.HashMap;

public class LongestEqual01 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 1, 0};
        System.out.println(maxLen(arr)); // 4
        System.out.println(longestEqual01(arr));
    }
    public static int maxLen(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i <n ; i++) {
            int zeroCount=0;
            int oneCount=0;
            for (int j = i; j <n ; j++) {
                if(arr[j]==0) zeroCount++;
                else oneCount++;

                if(zeroCount==oneCount){
                    maxLen=Math.max(maxLen,j-i+1);
                }

            }

        }
        return maxLen;
    }
    public static int longestEqual01(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int ps=0;
        int maxLen=0;
        for (int i = 0; i < arr.length ; i++) {
            ps+=(arr[i]==0?-1:1);
            if(map.containsKey(ps)){
                maxLen=Math.max(maxLen,i-map.get(ps));
            }else{
                map.put(ps,i);
            }

        }
        return maxLen;
    }
}
