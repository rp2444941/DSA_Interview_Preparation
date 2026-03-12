package arrays.level1;

import java.util.*;

public class SortColorsDNF {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
         sortColorsDNF(arr);
         System.out.println("After: " + Arrays.toString(arr));
    }

    // Same algorithm, but prints each step (visual understanding)
    private static void sortColorsDNF(int[] arr) {
        int low=0;
        int mid=0;
        int high= arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                // 0 ko left zone me vejna hai
                swap(arr,low,high);
                low++;
                mid++;
            } else if (arr[mid]==1) {
                // 1 middle zone me hi rahega, bas scan aage badhao
                mid++;

            }else{// arr[mid] == 2
                swap(arr,mid, high);
                high--;
                // mid++ intentionally nahi (new element at mid unchecked)
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

}
