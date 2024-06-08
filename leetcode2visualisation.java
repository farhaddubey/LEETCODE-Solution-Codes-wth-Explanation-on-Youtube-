*2. Add Two Numbers*
_*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.*_
Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation:
Before:    l1: 2 -> 4 -> 3
                  \
                   -> 5 -> 6 -> 4 :l2
After:     Result: 7 -> 0 -> 8

Before:    l1: 0
                  \
                   -> 0 :l2
After:     Result: 0

Before:    l1: 9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9
                  \
                   -> 9 -> 9 -> 9 -> 9 :l2
After:     Result: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


_*// To run the code rename the file name from leetcode* to Solution*_ 


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        _*// Temp head to simplify the handling of the head of the result list*_
        ListNode tempHead = new ListNode(0);
        ListNode p = l1, q = l2, current = tempHead;
        int carry = 0;
        
        _*// Looping through both lists until both are fully traversed*_
        while (p != null || q != null) {
            _*// Get the value of the current nodes, 0 if the node is null*_
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            
            _*// Sum the values and the carry*_
            int sum = carry + x + y;
            
            _*// Updating the carry for the next iteration*_
            carry = sum / 10;
            
            _*// Create a new node with the digit value (sum % 10) and attaching it to the current node*_
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            _*// Moving to the next nodes in l1 and l2 are not null*_
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        
        _*// If there's a carry left after the last addition, adding a new node with the carry value to the resulant list*_
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        _*// Returning the next of tempHead as the head of the result list*_
        return tempHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addTwoNumbers(l1, l2);
        printList(result); 
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