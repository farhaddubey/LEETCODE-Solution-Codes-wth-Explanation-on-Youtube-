class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode Solution(ListNode l1, ListNode l2) {
        // Dummy head to simplify the handling of the head of the result list
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;
        
        // Loop through both lists until both are fully traversed
        while (p != null || q != null) {
            // Get the value of the current nodes, 0 if the node is null
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            
            // Sum the values and the carry
            int sum = carry + x + y;
            
            // Update the carry for the next iteration
            carry = sum / 10;
            
            // Create a new node with the digit value (sum % 10) and attach it to the current node
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            // Move to the next nodes in l1 and l2 if they are available
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        
        // If there's a carry left after the last addition, add a new node with the carry value
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        // Return the next of dummyHead as the head of the result list
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.Solution(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}