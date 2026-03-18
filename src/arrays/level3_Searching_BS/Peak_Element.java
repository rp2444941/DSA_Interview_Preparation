package arrays.level3_Searching_BS;

public class Peak_Element {
    public static void main(String[] args) {
        int[] arr={1,2,1,3,5,6,4};
        System.out.println(peak(arr));

    }
    public static int peak(int[] arr){
        int start=0, end= arr.length-1;
        while (start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }

}
