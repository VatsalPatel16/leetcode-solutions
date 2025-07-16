package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        // slow and fast pointer to find the middle of the Linked List
        ListNode slow = head, fast = head;

        // Finding the middle
        while (fast != null && fast.next != null) {
            // move slow pointer by one node
            slow = slow.next;
            // and fast pointer by two nodes
            fast = fast.next.next;
        }

        // if size of the Linked List is odd then skip the middle
        // and go to next node
        if (fast != null) {
            slow = slow.next;
        }

        // reverse the Linked List from the slow pointer
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Now check both Lists
        while (prev != null) {
            // if any mismatch then return false
            if (head.val != prev.val) {
                return false;
            }
            // otherwise move to next node
            else {
                head = head.next;
                prev = prev.next;
            }
        }

        // if successful traversal then return true
        return true;
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