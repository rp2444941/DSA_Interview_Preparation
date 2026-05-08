package LinkedList.LEVEL_1;

public class Foundation {
    public static void main(String[] args) {
        Foundation list=new Foundation();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.insert(100,3);
        list.display();


    }
    private Node head;
    private Node tail;

    private int size;

    public Foundation() {
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }
    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        node=tail;
        size++;
    }
    public void insert(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp=head;
        for (int i = 1; i <index ; i++) {
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;

    }


    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"-->");
            temp=temp.next;
        }
        System.out.println("End");
    }


    private class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


}
