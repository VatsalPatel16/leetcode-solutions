package Easy;

// Time Complexity: O(n), where n is the number of nodes in the linked list
// Space Complexity: O(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        // Two pointers fast & slow
        ListNode slow = head, fast = head;

        // while fast is not equal to null and
        // fast.next is not equal to null do so
        while (fast != null && fast.next != null) {
            // Move slow pointer by one node
            slow = slow.next;
            // Move fast pointer by two node
            fast = fast.next.next;
        }

        // slow pointer will be pointing at middle of the node
        return slow;
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