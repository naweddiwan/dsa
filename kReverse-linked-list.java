public static Node<Integer> kReverse(Node<Integer> head, int k) {

    // If k is 0, no need to reverse, return the original head
    if (k == 0) {
        return head;
    }

    // Core logic for reversing the linked list in groups of k nodes:

    // Initialize pointers for current, new head, and tail
    Node<Integer> curr = head;
    Node<Integer> newHead = reverse(curr, k);  // Reverse the first k nodes
    Node<Integer> tail = curr;                 // Mark the end of the reversed segment

    // Iterate through the remaining linked list:
    while (tail != null) {
        // Save the previous reversed segment's tail
        Node<Integer> prev = curr;
        // Move to the next segment to be reversed
        curr = tail.next;

        // Reverse the next segment of k nodes
        Node<Integer> temp = reverse(curr, k);

        // Connect the previously reversed segment with the newly reversed segment
        prev.next = temp;

        // Update tail to point to the end of the newly reversed segment
        tail = curr;
    }

    // Return the final head of the reversed linked list
    return newHead;
}

// Helper function to reverse a given section of the linked list:
public static Node<Integer> reverse(Node<Integer> head, int k) {
    Node<Integer> curr = head;
    Node<Integer> prev = null;

    // Reverse the links for k nodes:
    while (curr != null && k > 0) {
        Node<Integer> temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
        k--;
    }

    // Connect the reversed segment to the remaining unreversed part:
    if (head != null) {
        head.next = curr;  // curr now points to the first node of the unreversed part
    }

    // Return the new head of the reversed segment
    return prev;
}
