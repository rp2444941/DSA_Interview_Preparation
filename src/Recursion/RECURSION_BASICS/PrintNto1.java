package Recursion.RECURSION_BASICS;

public class PrintNto1 {
    public static void main(String[] args) {
        //printN(6);
        printN(1);
    }
    public static void printN(int n) {
        // base condition
        if(n==5) return;
        printN(n+1);
        System.out.println(n);

    }
}
