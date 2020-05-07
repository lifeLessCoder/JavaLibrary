public class LinkedList {

    // No one should create an object
    private LinkedList() {
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int data) {
            val = data;
        }
    }

    /**
     * Reverse the given linked list
     * 
     * @param head of the linked list
     * @return head and tail of the reversed linked list
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode[] reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // Return head and tail
        return new ListNode[] { prev, head };
    }

    /**
     * Split the given linked list into 2 parts where first part contains k elements
     * and second part contains the remaining elements
     * 
     * @param head of the linked list
     * @param k    elements in first part
     * @return heads of the two parts after splitting
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode[] splitList(ListNode head, int k) {
        if (k == 0) {
            return new ListNode[] { null, head };
        }
        ListNode rem = head;
        ListNode prev = null;
        while (rem != null && k > 0) {
            prev = rem;
            rem = rem.next;
            k--;
        }
        if (prev != null) {
            prev.next = null;
        }
        return new ListNode[] { head, rem };
    }

    /**
     * Print the linked list
     * 
     * @param head of the linked list
     * 
     *             Time complexity : O(n) Space complexity : O(1)
     */
    public static void printList(ListNode head) {
        System.out.print("List : ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * Append given node to result list
     * 
     * @param result  list
     * @param newNode node to be appended
     * 
     *                Time complexity : O(1) Space complexity : O(1)
     */
    public static void appendNodeToResult(ListNode[] result, ListNode newNode) {
        if (result[0] == null) {
            result[0] = newNode;
            result[1] = newNode;
        } else {
            result[1].next = newNode;
            result[1] = newNode;
        }
    }

    /**
     * Append given list to result list
     * 
     * @param result list
     * @param head   of the given list
     * @param tail   of the given list
     * 
     *               Time complexity : O(1) Space complexity : O(1)
     */
    public static void appendListToResult(ListNode[] result, ListNode head, ListNode tail) {
        if (result[0] == null) {
            result[0] = head;
            result[1] = tail;
        } else if (head != null) {
            result[1].next = head;
            result[1] = tail;
        }
    }

    /**
     * Detect if a loop exists in the linked list
     * 
     * @param head of the linked list
     * @return null if no loop, else meeting point of slow and fast pointers
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode detectLoop(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }

    /**
     * Given a linked list with a loop, find the first node of the loop
     * 
     * @param head         of the linked list with a loop
     * @param meetingPoint of the slow and fast pointers
     * @return first node of the loop
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode findFirstNodeOfCycle(ListNode head, ListNode meetingPoint) {
        ListNode cur = head;
        while (cur != meetingPoint) {
            cur = cur.next;
            meetingPoint = meetingPoint.next;
        }
        return cur;
    }

    /**
     * Given a linked list with a loop, break the loop
     * 
     * @param head      of the linked list
     * @param loopStart first node of the loop
     * 
     *                  Time complexity : O(n) Space complexity : O(1)
     */
    public static void breakLoop(ListNode head, ListNode loopStart) {
        if (head == null || loopStart == null) {
            return;
        }
        ListNode cur = loopStart;
        while (cur.next != loopStart) {
            cur = cur.next;
        }
        cur.next = null;
    }

    /**
     * Delete a node (not first or last) given a pointer to that node
     * 
     * @param node to be deleted
     * 
     *             Time complexity : O(n) Space complexity : O(1)
     */
    public static void deleteNonExtremeNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * Insert a node after a given node
     * 
     * @param node      after which a new node is to be inserted
     * @param insertVal value to insert after node
     * 
     *                  Time complexity : O(1) Space complexity : O(1)
     */
    public static void insertAfter(ListNode node, int insertVal) {
        if (node == null) {
            System.out.println("insertAfter : node is null");
            return;
        }
        ListNode newNode = new ListNode(insertVal);
        newNode.next = node.next;
        node.next = newNode;
    }

    /**
     * Check if a given val is in range of 2 nodes in a sorted list
     * 
     * @param a   first node
     * @param val to check for
     * @param b   second node
     * @return true if val is in range of node a and node b
     * 
     *         Time complexity : O(1) Space complexity : O(1)
     */
    public static boolean isInRange(ListNode a, int val, ListNode b) {
        if (a == null || b == null) {
            return false;
        }
        return (a.val <= val && val <= b.val);
    }

    /**
     * Insert a value into a sorted circular linked list and keep the order
     * 
     * @param head      any node in a circular linked list
     * @param insertVal value to be inserted
     * @return head
     * 
     *         Time complexity : O(1) Space complexity : O(1)
     */
    public static ListNode insertIntoSortedCircularList(ListNode head, int insertVal) {
        if (head == null) {
            ListNode node = new ListNode(insertVal);
            node.next = node;
            return node;
        } else {
            ListNode prev = head;
            ListNode next = head.next;

            while (next != head) {
                if (isInRange(prev, insertVal, next)
                        || (prev.val > next.val && (insertVal >= prev.val || insertVal <= next.val))) {
                    insertAfter(prev, insertVal);
                    return head;
                } else {
                    prev = prev.next;
                    next = next.next;
                }
            }
            insertAfter(prev, insertVal);
            return head;
        }
    }

    /**
     * Delete the k-th last node in singly linked list
     * 
     * @param head of the linked list
     * @param k
     * @return the head of the linked list
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode deleteKth

    LastNode(ListNode head, int k) {
        ListNode nodeBeforeKthLastNode = getNodeBeforeKthLastNode(head, k);
        head = deleteNode(nodeBeforeKthLastNode, head);
        return head;
    }

    /**
     * Get the node before the k-th last node
     * 
     * @param head of the linked list
     * @param k
     * @return node before the k-th last node
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode getNodeBeforeKthLastNode(ListNode head, int k) {
        ListNode slow = null, fast = null;

        fast = getKthNode(head, k);

        while (fast.next != null) {
            fast = fast.next;
            if (slow == null) {
                slow = head;
            } else {
                slow = slow.next;
            }
        }

        return slow;
    }

    /**
     * Get the k-th node
     * 
     * @param head of the linked list
     * @param k
     * @return the k-th node
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode getKthNode(ListNode head, int k) {
        ListNode node = null;
        for (int i = 1; i <= k; i++) {
            if (node == null) {
                node = head;
            } else {
                node = node.next;
            }
        }
        return node;
    }

    /**
     * Delete the node after the given node
     * 
     * @param node before the node to be deleted
     * @param head of the linked list
     * @return the head of the linked list after deleting the node
     * 
     *         Note : 1. If you want to delete the head, pass in null for node
     * 
     *         Time complexity : O(1) Space complexity : O(1)
     */
    public static ListNode deleteNode(ListNode node, ListNode head) {
        if (node == null) {
            head = head.next;
        } else if (node.next != null) {
            node.next = node.next.next;
        }
        return head;
    }

    /**
     * Remove all elements which appear more than once in a sorted linked list
     * 
     * @param head of the linked list
     * @return head of the linked list after removal of duplicates
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode removeDuplicatesFromList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {

            // Skip duplicates if they exist
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }

            if (prev.next == cur) {
                // No duplicates
                prev = cur;
            } else {
                // Duplicates
                prev.next = cur.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }

}