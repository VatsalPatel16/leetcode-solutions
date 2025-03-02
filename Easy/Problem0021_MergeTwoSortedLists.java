package Easy;

// Time Complexity: O(n + m)
// where, n is number of nodes in list1 and m is number of nodes in list2
// Space Complexity: O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // list to store output
        ListNode dummy = new ListNode();
        // head pointer pointing at the first node of duumy LL
        ListNode head = dummy;

        // while list1 and list2 is not null do so
        while (list1 != null && list2 != null) {
            // if value in list1 is less than value in list2 then add node from list1
            // and update list1 pointer
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            }
            // otherwise add node from list2 and update list2 pointer
            else {
                dummy.next = list2;
                list2 = list2.next;
            }
            // update dummy pointer
            dummy = dummy.next;
        }
        // if list1 is not null then add that to dummy list
        if (list1 != null) {
            dummy.next = list1;
        }
        // or else list2 is not null then add that to dummy list
        else if (list2 != null) {
            dummy.next = list2;
        }

        return head.next;
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