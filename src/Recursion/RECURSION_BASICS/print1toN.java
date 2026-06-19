package Recursion.RECURSION_BASICS;

public class print1toN {
    public static void main(String[] args) {
        print1(1);

    }
    public static void print1(int n){
        if(n==5) return;
        System.out.println(n);
        print1(n+1);
       // System.out.println(n);
    }

}
