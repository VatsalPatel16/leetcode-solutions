package Medium;

// Time Complexity: O(n), where n is the number of nodes in the Linked List
// Space Complexity: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // if LL is empty return null
        if (head == null) {
            return null;
        }

        int n = 0;
        // end pointer to keep track of end of LL
        ListNode end = head;
        // loop to put end pointer to end of LL
        while (end.next != null) {
            n++;
            end = end.next;
        }
        n++;
        // k % length of LL to avoid unnecessary rotation
        k %= n;
        // Converting right rotation to left rotation
        k = n - k;
        // pointer start at the starting of LL
        ListNode start = head;
        // k rotations
        for (int i = 0; i < k; i++) {
            end.next = start;
            start = start.next;
            end = end.next;
            end.next = null;
        }

        return start;
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