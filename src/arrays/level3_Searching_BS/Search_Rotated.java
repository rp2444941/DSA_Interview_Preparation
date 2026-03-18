package arrays.level3_Searching_BS;

public class Search_Rotated {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        int target=0;
        int ans=search(arr,target);
        System.out.println(ans);
    }
    public static int search(int[] arr, int target) {
        int start=0, end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(arr[mid]==target){
                return mid;
            }
            // Left half sorted
            if(arr[start]<=arr[mid]){
                if(target>=arr[start] && target<arr[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }

            // Right half sorted
            else{
                if(target>arr[mid] && target<=arr[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;

    }
}
