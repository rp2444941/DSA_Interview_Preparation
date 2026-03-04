package arrays.level1;

public class LeftRotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        leftRotateByOne(arr);
        for(int num :arr){
            System.out.println(num + " ");
        }
    }
    public static void leftRotateByOne(int[] arr){
        if(arr.length == 0) return;
        int first=arr[0];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=arr[i+1];// shift element left


        }
        arr[arr.length-1]=first;// put first element at end;
    }

}
