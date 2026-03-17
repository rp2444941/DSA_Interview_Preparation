package arrays.level3_Searching_BS;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,11};
        int target=7;
        int ans=BS(arr,target);
        int ans1=binarySearch(arr,0, arr.length-1,target );
        System.out.println(ans1);
        System.out.println(ans);
    }
    //O(log n) because n → n/2 → n/4 → n/8 → ...
    //
    private static int BS(int[] arr, int target) {
        int n=arr.length-1;
        int low=0, high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if (arr[mid]==target) return mid;
            else if (arr[mid]>target) {
                high=mid-1;

            }else {
                low=mid+1;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int low, int high, int target){
        if(low>high){
            return -1;
        }
        int mid=low+(high-low)/2;
        if(arr[mid]==target) return mid;
        else if (arr[mid]<target) {
            return binarySearch(arr, mid + 1, high, target);

        }else{
            return binarySearch(arr,low,mid-1,target);
        }

    }

}
