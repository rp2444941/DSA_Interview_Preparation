package arrays.level1;
import java.util.*;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] arr={1,3,4,2,2};
        System.out.println(findDuplicate(arr));
        System.out.println(findDuplicateNumber(arr));
    }
    public static int findDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int num :arr){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }
    //Floyd’s Algorithm (Tortoise & Hare)
    public static int findDuplicateNumber(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        // step 1:Detect cycle
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow !=fast);
// Step 2: Find entry point
        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
