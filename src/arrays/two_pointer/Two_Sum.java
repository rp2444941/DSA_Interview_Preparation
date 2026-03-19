package arrays.two_pointer;

import java.util.Arrays;

public class Two_Sum {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,6};
        int target=6;
        System.out.println(Arrays.toString(sum(arr,target)));

    }
    public static int[] sum(int[] arr,int target){
        int start=0;
        int end= arr.length-1;
        while(start<end){
            int sum=arr[start]+arr[end];
            if(sum==target){
                return new int[]{start,end};
            } else if (sum>target) {
                end--;

            }else{
                start++;
            }
        }
        return new int[]{-1,-1};
    }


}
