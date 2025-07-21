package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // if given head is null return null
        if (head == null) {
            return null;
        }

        // using two pointers prev & curr to traverse linked list
        ListNode prev = head;
        ListNode curr = prev.next;

        // while curr is not equal to null do so
        while (curr != null) {
            // if both prev and curr val are same then remove curr node from the list
            if (prev.val == curr.val) {
                prev.next = curr.next;
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp;
            }
            // otherwise move both pointers to next node
            else {
                prev = prev.next;
                curr = curr.next;
            }
        }

        return head;
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