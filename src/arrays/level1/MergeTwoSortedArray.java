package arrays.level1;
import java.util.*;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        System.out.println(Arrays.toString(mergeSorted(arr1, arr2)));

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        mergeInPlace(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    private static void mergeInPlace(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;// nums1 ka last valid element
        int j=n-1;// nums2 ka last element
        int k=m+n-1;// nums1 ka last index (yahin fill karenge)
        while(i>=0 && j>=0){
            // bigger element ko end me rkho
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                i--;
            }else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
        // agar nums2 me elements bache hain, to copy
        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
        // nums1 ke leftover elements already correct place pe hote hain
    }

    //Time: O(n+m)
    //Space: O(n+m)
    private static int[] mergeSorted(int[] arr1, int[] arr2) {
        int n=arr1.length,m=arr2.length;
        int[] res=new int[n+m];
        int i=0, j=0, k=0;
        // jab tak dono arrays me elements bache hain
        while(i<n && j<m){
            // <= isliye: stability (equal ho to a wala pehle)
            if(arr1[i]<=arr2[j]){
                res[k]=arr1[i];
                i++;
            }else{
                res[k]=arr2[j];
                j++;
            }
            k++;

        }
        //leftover element copy
        while(i<n){
            res[k++]=arr1[i++];
        }
        while(j<m){
            res[k++]=arr2[j++];
        }
        return res;
    }
}
