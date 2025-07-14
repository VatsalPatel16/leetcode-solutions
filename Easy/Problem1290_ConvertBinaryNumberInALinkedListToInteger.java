package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int getDecimalValue(ListNode head) {
        // res to store output
        int res = 0;

        // Traverse over given linked list
        while (head != null) {
            // using left shift and OR bitwise operator
            // to convert given binary number into integer
            res = (res << 1) | head.val;
            // moving head pointer to next node
            head = head.next;
        }

        return res;
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}