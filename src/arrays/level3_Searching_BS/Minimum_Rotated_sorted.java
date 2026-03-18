package arrays.level3_Searching_BS;

public class Minimum_Rotated_sorted {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(minimum(arr));

    }
    public static int minimum(int[] arr){
        int start=0, end= arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[end]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return arr[start];
    }

}
