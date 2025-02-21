package Easy;

// Time Complexity: O(n) (Each node is visited at most once)
// Space Complexity: O(1) (We only used two pointers fast & slow)
class Solution {
    public boolean hasCycle(ListNode head) {
        // Two pointers fast and slow
        ListNode fast = head;
        ListNode slow = head;

        // while fast pointer don't reach to null do so
        while (fast != null && fast.next != null) {
            // update fast pointer by two steps
            fast = fast.next.next;
            // update slow pointer by one step
            slow = slow.next;
            // if fast and slow pointer at same position return true
            // cycle detected
            if (fast == slow) {
                return true;
            }
        }
        // otherwise not found cycle return false
        return false;
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