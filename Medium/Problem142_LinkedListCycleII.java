package Medium;

// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution {
    public ListNode detectCycle(ListNode head) {
        // Two pointers fast and slow
        ListNode fast = head, slow = head;

        // while fast and fast.next is not equal to null do so
        while (fast != null && fast.next != null) {
            // move fast by 2 steps
            fast = fast.next.next;
            // move slow by 1 step
            slow = slow.next;
            // if fast equal to slow then cycle detected break out the loop
            if (fast == slow) {
                break;
            }
        }
        // if fast or fast.next is equal to null then no loop in the linked list
        // return null in that case
        if (fast == null || fast.next == null) {
            return null;
        }

        // otherwise add another pointer entry from the start(head) of the linked list
        ListNode entry = head;
        // while entry is not equal to slow do so
        while (entry != slow) {
            entry = entry.next;
            slow = slow.next;
        }

        return entry;
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
