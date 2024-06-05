class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Here, We'll be using temporary head pointer to point the head of final result list 
        ListNode tempHead=new ListNode(0);
        ListNode p=l1, q=l2, current=tempHead;
        // Here we assigned ptr to the corresponding list  
        int carry=0; 
        // Now to add them we need to loop through both the List & add. 
        while(p!=null || q!=null){
            int x=(p!=null)?p.val:0; 
            //Again checking same things as individualluy they can be 0
            int y=(q!=null)?q.val:0;
            int sum=carry+x+y;
            carry=sum/10;
            // As the division result is added to Next & remainder replaces at prev location
            current.next=new ListNode(sum%10);
            // So added a member to the result List as the remainder is at prev location
            current=current.next;
            // Moving ptr of p1 & p2 to the Next element 
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        // if carry somehow left after the addiion of Entire list, We'll be adding a newnode 
        // with the carriage value with the result node, 
        // & always the carriage is added to the next nodes 
        if(carry>0){
            current.next=new ListNode(carry);
        }
        return tempHead.next;
        
    }
    public static void main(String[] args){
        Solution sol1 = new Solution();
        // ListNode l1 = new ListNode();
        // ListNode l2 = new ListNode();
        ListNode result = new ListNode();
        // For assinging the data We've to use the 3rd constructor of ListNode class 
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        // Here both the 2nd & 3rd consttructor is used.
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        result = sol1.addTwoNumbers(l1, l2);
    }
}
