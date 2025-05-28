package Easy;

// Time Complexity: O(n), where n is number of nodes in the Linked List
// Space Complexity: O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        // Two pointers
        ListNode prev = null;
        ListNode curr = head;

        // while curr is not equal to null do so
        while (curr != null) {
            // temp node to store link of curr node
            ListNode temp = curr.next;
            // change link of curr node to prev
            curr.next = prev;
            // update both pointers
            prev = curr;
            curr = temp;
        }

        return prev;
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