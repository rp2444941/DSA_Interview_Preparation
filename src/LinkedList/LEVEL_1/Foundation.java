package LinkedList.LEVEL_1;

public class Foundation {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    // Q2 & Q3: Traverse and Count
    public void display(Node head){
        Node temp=head;// Head ko hamesha safe rakho, temp move karo
        int count=0;
        while(temp!=null){
            System.out.println(temp.data +"-->");
            temp=temp.next;
            count++;
        }
        System.out.println("null | Total Node: "+ count);
    }

}
