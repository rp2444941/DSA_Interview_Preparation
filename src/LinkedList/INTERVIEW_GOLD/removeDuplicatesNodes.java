package LinkedList.INTERVIEW_GOLD;

 class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class removeDuplicatesNodes {
    public static void main(String[] args) {
        // Creating linked list: 1->1->2->3->3
        ListNode ll = new ListNode(1);
        ll.next = new ListNode(1);
        ll.next.next = new ListNode(2);
        ll.next.next.next = new ListNode(3);
        ll.next.next.next.next = new ListNode(3);
        System.out.print("Original List: ");
        display(ll);
        ll= removeDuplicates(ll);
        System.out.print("After removing duplicates: ");
        display(ll);
    }

    public static ListNode removeDuplicates(ListNode head) {
        ListNode current = head;
        while(current!=null && current.next!=null){
            if(current.val==current.next.val){
                current.next=current.next.next;
            }else{
                current=current.next;
            }
        }
        return head;
    }
    public static void display(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
        System.out.println("END");
    }

}
