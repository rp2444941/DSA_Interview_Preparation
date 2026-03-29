package stack_Queue;
import java.util.*;
import java.util.Stack;
public class MinStack {
    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(5);
        st.push(2);
        st.push(10);
        st.push(1);

        System.out.println(st.getMin()); // 1
        st.pop();
        System.out.println(st.getMin()); // 2
    }
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    public MinStack(){
        minStack=new Stack<>();
        minStack=new Stack<>();
    }
    public void push(int val){
        minStack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);

        }
    }
    public void pop(){
        if(minStack.isEmpty()) return;
        int remove=minStack.pop();
        if(remove==minStack.peek()){
            minStack.pop();
        }
    }
    public int top(){
        return minStack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}
