package arrays.level3_Searching_BS;

import java.util.Arrays;

public class first_last_element {

    public static void main(String[] args) {

        int[] arr = {2,4,4,4,4,6,8};
        int target = 4;

        first_last_element obj = new first_last_element();

        int[] ans = obj.searchRange(arr, target);

        System.out.println(Arrays.toString(ans));
    }

    public int firstOccurrence(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                ans = mid;
                end = mid - 1;   // left side search
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public int lastOccurrence(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                ans = mid;
                start = mid + 1;   // right side search
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] arr, int target) {

        return new int[]{
                firstOccurrence(arr, target),
                lastOccurrence(arr, target)
        };
    }
}