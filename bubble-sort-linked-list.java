// Function to sort a linked list using bubble sort
public static Node<Integer> bubbleSort(Node<Integer> head) {

    // Handle cases with empty or single-node lists
    if (head == null || head.next == null) {
        return head;  // Already sorted
    }

    // Outer loop to iterate through the list multiple times
    for (int i = 0; i < lengthLL(head) - 1; i++) {

        // Initialize pointers for current, previous, and next nodes
        Node<Integer> prev = null;
        Node<Integer> curr = head;
        Node<Integer> next = curr.next;

        // Inner loop to compare adjacent elements and swap if necessary
        while (curr.next != null) {
            if (curr.data > curr.next.data) {  // Swap elements if out of order

                // If at the beginning of the list, update head pointer
                if (prev == null) {
                    curr.next = next.next;
                    next.next = curr;
                    prev = next;
                    head = prev;
                } else {
                    // Swap elements within the list
                    next = curr.next;
                    curr.next = next.next;
                    prev.next = next;
                    next.next = curr;
                    prev = next;
                }
            } else {
                // Move pointers forward if elements are in order
                prev = curr;
                curr = curr.next;
            }
        }
    }

    return head;  // Return the sorted linked list
}

// Helper function to calculate the length of the linked list
private static int lengthLL(Node<Integer> head) {
    int count = 1;
    while (head.next != null) {
        head = head.next;
        count++;
    }
    return count;
}
