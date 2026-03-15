package arrays.level2;
import java.util.Arrays;
import java.util.PriorityQueue;

//import static arrays.level1.SortColorsDNF.swap;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr={3,2,1,5,6,4};
        int k=2;
        System.out.println(findKthLargest(arr,k));
        System.out.println(KthLargest(arr,k));
        System.out.println(findKthLargestQuick(arr,k));
    }
    //O(n log n) t.c
    public static int findKthLargest(int[] arr,int k){
        Arrays.sort(arr);
        return arr[arr.length-k];

    }
  //Min Heap
//    Time: O(n log k)
//    Space: O(k)
  public static int  KthLargest(int[] arr,int k) {
      PriorityQueue<Integer> minHeap=new PriorityQueue<>();
      for(int num:arr){
         minHeap.add(num);
         if (minHeap.size()>k){
             minHeap.poll();
         }
      }
        return minHeap.peek();
  }
//Quickselect
    public static int findKthLargestQuick(int[] arr,int k){
        int target= arr.length-k;
        return quickSelect(arr,0,arr.length-1,target);
    }

    private static int quickSelect(int[] nums, int left, int right, int target) {
        int pivot = partition(nums, left, right);

        if(pivot == target) return nums[pivot];
        else if(pivot < target)
            return quickSelect(nums, pivot + 1, right, target);
        else
            return quickSelect(nums, left, pivot - 1, target);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for(int j = left; j < right; j++) {
            if(nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }




}
