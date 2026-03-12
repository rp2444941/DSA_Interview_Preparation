package arrays.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {2, 2, 4};
        int[] brute = intersectionBrute(arr1, arr2);
        int[] optimal = intersectionOptimal(arr1, arr2);
        System.out.println("arr1 = "+ Arrays.toString(arr1));
        System.out.println("arr2 = "+ Arrays.toString(arr2));
        System.out.println("brute Intersection = " + Arrays.toString(brute));
        System.out.println("Optimal Intersection = " + Arrays.toString(optimal));

    }

    // ---------- BRUTE FORCE: O(n*m) ----------
    // Unique intersection chahiye, isliye Set use kar rahe hain
    static int[] intersectionBrute(int[] nums1, int[] nums2) {
        Set<Integer> res=new HashSet<>(); // unique result store
        for (int i = 0; i < nums1.length ; i++) {
            for (int j = 0; j < nums2.length ; j++) {
                if(nums1[i] ==nums2[j]){// match mila
                    res.add(nums1[i]);
                    break;
                }

            }

        }
        // set --> int[]
        int[] ans=new int[res.size()];
        int k=0;
        for(int x:res) ans[k++]=x;

        return ans;

    }

    //Optimal: o(n+m) average
    static int[] intersectionOptimal(int[] nums1, int[] nums2) {
        // nums1 ke unique elements ka set
        Set<Integer> set1=new HashSet<>();
        for(int x: nums1){
            set1.add(x);

        }
        // intersection unique store
        Set<Integer> inter=new HashSet<>();
        for(int y: nums2){
            if(set1.contains(y)){// fast lookup
                inter.add(y); // unique add
            }
        }
        //Set -->int[]
        int[] ans=new int[inter.size()];
        int i=0;
        for(int val : inter) ans[i++]=val;
        // OPTIONAL: agar sorted output chahiye to
        Arrays.sort(ans);
        return ans;

    }
}
