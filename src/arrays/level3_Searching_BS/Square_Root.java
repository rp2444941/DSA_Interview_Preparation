package arrays.level3_Searching_BS;

public class Square_Root {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Floor sqrt of " + n + " = " + floorSqrt(n));
    }

    private static int floorSqrt(int n) {
        if(n==0 || n==1) return n;
        int start=0;
        int end=n;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            // Safe condition to avoid overflow
            if(mid<=n/mid){
                ans=mid;// store possible answer
                start=mid+1;// try bigger value
            }else{
                end=mid-1;// go left
            }
        }
        return ans;
    }
}
