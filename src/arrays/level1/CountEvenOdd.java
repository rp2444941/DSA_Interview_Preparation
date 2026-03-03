package arrays.level1;

public class CountEvenOdd {
    public static void main(String[] args) {
        int[] arr={2,5,7,8,10};
        int[] result = countEvenOdd(arr); // result[0] = even, result[1] = odd
        System.out.println("Even count: " + result[0]);
        System.out.println("Odd count: " + result[1]);
    }

    private static int[] countEvenOdd(int[] arr) {
        int even=0;
        int odd=0;
        for(int num:arr){
            if(num%2==0){
                even++;
            }else{
                odd++;
            }
        }
        return new int[]{even, odd};
    }


}
