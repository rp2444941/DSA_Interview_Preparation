package arrays.level1;

import java.util.HashSet;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr={0,1,2,4,5};
        System.out.println(missingNumber(arr));
        System.out.println(findMissing(arr));
        System.out.println(findMissingBySum(arr));
        System.out.println(findMissingByXOR(arr));
        System.out.println(findMissingByHashing(arr));
    }
    public static int missingNumber(int[] arr){
        int n=arr.length;
        for (int i = 0; i <=n ; i++) {
            boolean found=false;
            for (int j = 0; j <n ; j++) {
                if(arr[j]==i){
                    found=true;
                    break;
                }

            }
            if(!found){
                return i;
            }

        }
        return -1;

    }
    //Sorted Case
    public static int findMissing(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=i){
                return i;
            }

        }
        return arr.length;

    }
    //Time: O(n)
    //Space: O(1)
    public static int findMissingBySum(int[] arr) {
        int n= arr.length;
        int expectedSum=n*(n+1)/2;
        int actualSum=0;
        for(int num:arr){
            actualSum+=num;
        }
        return expectedSum-actualSum;

    }
    // Time: O(n)
    //Space: O(1)
    public static int findMissingByXOR(int[] arr) {
        int n = arr.length;
        int xor = 0;

        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        for (int num : arr) {
            xor ^= num;
        }

        return xor;
    }
    public static int findMissingByHashing(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        for (int i = 0; i <arr.length ; i++) {
            if(!set.contains(i)){
                return i;
            }

        }
        return -1;
    }

}
