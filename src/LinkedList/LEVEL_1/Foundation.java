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
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deletelast());
        list.display();
        System.out.println(list.delete(2));
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

    // Delete node
    public int deleteFirst(){
        int val=head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }
    public int deletelast(){
        if(size<=1){
            return deleteFirst();
        }
        Node scLast=get(size-2);
        int val=tail.value;
        tail=scLast;
        tail.next=null;
        return val;
    }
    public int delete(int index){
        if(index==0){
           return deleteFirst();
        }
        if(index== size-1){
            return  deletelast();
        }
        Node prev=get(index-1);
        int val=prev.next.value;
        prev.next=prev.next.next;
        return val;

    }

    public Node get(int index){
        Node node=head;
        for (int i = 0; i <index; i++) {
            node=node.next;

        }
        return node;
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
