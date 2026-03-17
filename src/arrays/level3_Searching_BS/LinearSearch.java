package arrays.level3_Searching_BS;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={5,3,7,1};
        int target=7;
        int ans=LS(arr,target);
        System.out.println(ans);


    }
    //array unsorted ho and size small ho tab ls use krna hai
    //t.c=o(n)
    //s.c=o(1)
    public static int LS(int[] arr,int target){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]==target){
                return i;
            }

        }
        return -1;
    }

}
