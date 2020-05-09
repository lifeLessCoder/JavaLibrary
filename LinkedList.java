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
        if (head == null) {
            return null;
        }
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
    public static ListNode deleteKthLastNode(ListNode head, int k) {
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

    /**
     * Split given list into 2 parts where 1st part is the 1st node and second part
     * is the remaining list
     * 
     * @param head of the linked list
     * @return [firstNode, head of the remaining linked list]
     * 
     *         Time complexity : O(1) Space complexity : O(1)
     */
    public static ListNode[] extractFirstNode(ListNode head) {
        if (head == null) {
            return new ListNode[] { null, null };
        }
        ListNode firstNode = head;
        ListNode remaining = head.next;
        // Disconnect
        firstNode.next = null;
        return new ListNode[] { firstNode, remaining };
    }

    /**
     * Given 2 sorted lists merge them into a sorted list
     * 
     * @param l1 head of list 1 of size m
     * @param l2 head of list 2 of size n
     * @return head of sorted merged list
     * 
     *         Time complexity : O(m + n) Space complexity : O(1)
     */
    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode[] result = new ListNode[] { null, null };
        ListNode[] parts;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                parts = extractFirstNode(l1);
                appendNodeToResult(result, parts[0]);
                l1 = parts[1];
            } else {
                parts = extractFirstNode(l2);
                appendNodeToResult(result, parts[0]);
                l2 = parts[1];
            }
        }

        if (l1 != null) {
            appendNodeToResult(result, l1);
        } else if (l2 != null) {
            appendNodeToResult(result, l2);
        }

        return result[0];
    }

    /**
     * Get the mid node (2nd mid node if even number of nodes)
     * 
     * @param head of the linked list
     * @return the mid node
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Get the node before the mid node (2nd mid node if even number of nodes)
     * 
     * @param head of the linked list
     * @return node before the mid node
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode getNodeBeforeMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    /**
     * Move the mid node to the head of the list
     * 
     * @param head of the linked list
     * @return new list with the mid node at the head
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public ListNode moveMiddleToHead(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 1. Get the node before the mid node
        ListNode prevOfMid = getNodeBeforeMidNode(head);
        ListNode mid = prevOfMid.next;

        // 2. Remove mid from list
        prevOfMid.next = mid.next;

        // 3. Make mid node's next point to the head of the list
        mid.next = head;

        // 4. Update the new head to the mid node
        dummy.next = mid;

        return dummy.next;

    }

    /**
     * Get the number of nodes in the linked list
     * 
     * @param head of the list with n nodes
     * @return num of nodes n
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static int getNumOfNodes(ListNode head) {
        int numOfNodes = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            numOfNodes++;
        }
        return numOfNodes;
    }

    /**
     * Skip nodes in a linked list
     * 
     * @param head of the linked list
     * @param k    nodes to skip
     * @return the (k+1)th node
     * 
     *         Time complexity : O(k) Space complexity : O(1)
     */
    public static ListNode skipNodes(ListNode head, int k) {
        for (int i = 0; i < k && head != null; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * Return the intersection point of 2 lists of equal lengths
     * 
     * @param firstPtr  first list of length n
     * @param secondPtr second list of length n
     * @return intersection point if exists else null
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode getIntersectionPoint(ListNode firstPtr, ListNode secondPtr) {
        while (firstPtr != null && secondPtr != null && firstPtr != secondPtr) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }
        return firstPtr;
    }

    /**
     * Return the intersection point of 2 lists of unequal/equal lengths
     * 
     * @param head1 first list of length m
     * @param head2 second list of length n
     * @return intersection node if exists else null
     * 
     *         Time complexity : O(m+n) Space complexity : O(1)
     */
    public static ListNode getIntersectionOfTwoLists(ListNode head1, ListNode head2) {
        int numOfNodesList1 = getNumOfNodes(head1);
        int numOfNodesList2 = getNumOfNodes(head2);
        int differenceInNumOfNodes = Math.abs(numOfNodesList1 - numOfNodesList2);

        ListNode firstPtr = head1;
        ListNode secondPtr = head2;

        if (numOfNodesList1 > numOfNodesList2) {
            firstPtr = skipNodes(head1, differenceInNumOfNodes);
        } else if (numOfNodesList2 > numOfNodesList1) {
            secondPtr = skipNodes(head2, differenceInNumOfNodes);
        }

        return getIntersectionPoint(firstPtr, secondPtr);
    }

    /**
     * Extract the list
     * 
     * @param nodeBeforeHead
     * @param tail
     * @return the head and tail after extracting list
     * 
     *         Time complexity : O(1) Space complexity : O(1)
     */
    public static ListNode[] extractList(ListNode nodeBeforeHead, ListNode tail) {
        if (nodeBeforeHead == null || tail == null) {
            return null;
        }
        ListNode head = nodeBeforeHead.next;
        nodeBeforeHead.next = null;
        tail.next = null;
        return new ListNode[] { head, tail };
    }

    /**
     * Stitch sublist into another list
     * 
     * @param nodeBeforeHead first end of the list to be stitched into
     * @param list           head and tail of the list to be stitched
     * @param nodeAfterTail  second end of the list to be stitched into
     * 
     *                       Example : Input : 1->2->3 4->5->6 7->8->9
     * 
     *                       Output : 1->2->3->4->5->6->7->8->9
     *
     *                       Time complexity : O(1) Space complexity : O(1)
     */
    public static void stitchSublist(ListNode nodeBeforeHead, ListNode[] list, ListNode nodeAfterTail) {
        if (nodeBeforeHead == null || list == null || list[0] == null || list[1] == null) {
            return;
        }
        nodeBeforeHead.next = list[0];
        list[1].next = nodeAfterTail;
    }

    /**
     * Reverse contiguous even elements
     * 
     * @param head of list of length n
     * @return head after reversing contiguous even elements
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode reverseEvenElements(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Prev points to the part of the list upto which nodes are reversed
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode prevOfCur = dummy;

        while (cur != null) {
            while (cur != null && cur.val % 2 == 0) {
                prevOfCur = cur;
                cur = cur.next;
            }

            if (prev.next != cur && prev.next.next != cur) {
                // At least 2 contiguous even elements
                ListNode[] extractedList = extractList(prev, prevOfCur);
                extractedList = reverseLinkedList(extractedList[0]);
                stitchSublist(prev, extractedList, cur);
            }

            prev = cur;
            if (cur != null) {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    /**
     * Sort a linked list
     * 
     * @param head of linked list
     * @return head of the sorted list
     * 
     *         Time complexity : O(nlogn) Space complexity : O(logn)
     */
    public static ListNode mergeSort(ListNode head) {
        // Base case : if single or null node return it
        if (head == null || head.next == null) {
            return head;
        }

        // General case

        // 1. Divide list into 2 halves
        ListNode[] halves = splitListToHalves(head);

        // 2. Sort both the halves
        halves[0] = mergeSort(halves[0]);
        halves[1] = mergeSort(halves[1]);

        // 3. Merge the sorted halves
        return mergeTwoSortedLists(halves[0], halves[1]);
    }

    /**
     * Split list to 2 equal parts
     * 
     * @param head of the linked list of size n
     * @return heads of the 2 parts
     * 
     *         Time complexity : O(n) Space complexity : O(1)
     */
    public static ListNode[] splitListToHalves(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // Get the node before mid node
        ListNode nodeBeforeMid = getNodeBeforeMidNode(head);

        // Second list starts at mid
        ListNode head2 = nodeBeforeMid.next;

        // Split the list into 2 equal parts
        nodeBeforeMid.next = null;

        return new ListNode[] { head, head2 };
    }
}