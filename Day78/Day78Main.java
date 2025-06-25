public class Day78Main{
    // Definition for singly-linked list.
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Solution class containing the sortList method
    public static class Solution{
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode mid = getMid(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);

            return merge(left, right);
        }

        private ListNode getMid(ListNode head){
            ListNode slow = head, fast = head, prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            if (prev != null) prev.next = null;
            return slow;
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode tail = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }

            tail.next = (l1 != null) ? l1 : l2;

            return dummy.next;
        }
    }

    // Helper method to create a linked list from an array
    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = {4, 2, 1, 3}; // Example input
        ListNode head = buildList(input);

        System.out.print("Original List: ");
        printList(head);

        Solution solution = new Solution();
        ListNode sorted = solution.sortList(head);

        System.out.print("Sorted List: ");
        printList(sorted);
    }
}

/* Key Logic:

- The problem is solved using **Merge Sort**, which is ideal for linked lists due to its O(n log n)
  time complexity and minimal extra space requirements.

- Base Case Check:
  - If the list is empty or has only one node (`head == null || head.next == null`), it's already sorted.

- Finding the Middle:
  - Uses the **fast and slow pointer** technique.
  - Fast moves two steps, slow moves one step; when fast reaches the end, slow is at the middle.
  - This helps split the list into two halves for sorting.

- Splitting the List:
  - After finding the mid, we disconnect the first half by setting `prev.next = null`.

- Recursive Sort:
  - `sortList` is recursively called on both halves.
  - Each call continues to divide until base cases are hit.

- Merging Sorted Lists:
  - `merge` function combines two sorted lists into one.
  - A dummy node simplifies handling of the head pointer.
  - Standard two-pointer logic: compare values and attach the smaller node.

- Helper Methods:
  - `buildList(int[])`: Converts an array to a linked list.
  - `printList(ListNode)`: Prints the linked list in readable format.

- This implementation uses **O(log n)** space due to recursion. For strict O(1) space,
  an **iterative bottom-up merge sort** would be required (more complex). */
