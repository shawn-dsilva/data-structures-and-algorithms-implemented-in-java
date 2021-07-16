package LinkedList;

// Node Class, a node is an element of the Linked List
// Nodes are chained together using next/previous fields to make a Linked List
class Node {

    // Node data
    public String dataKey;
    public int dataValue;

    // Reference to next node after this one
    // if this node is the last one, this is set to null
    public Node next;

    // Reference to previous node before this node
    // If this is the first node, this is set to null
    public Node previous;

    public Node(String dataKey, int dataValue) {
        this.dataKey = dataKey;
        this.dataValue = dataValue;
    }

    public void display(int index) {

        System.out.println("["+index+"] "+dataKey + ": " + dataValue);
    }

    public String toString() {
        return dataKey;
    }


}

class ListIterator<T> {

    Node current;
    Node previous;

    DoublyLinkedList list;

    ListIterator(DoublyLinkedList list) {

        this.list = list;
        current = list.head;
        previous = list.tail;

    }

    public boolean hasNext() {
        return current != null;
    }

    public Node next() {
            Node data = current;
            current = current.next;

            return data;
    }

}

public class DoublyLinkedList {

    Node head;
    Node tail;
    int size = 0;

    // Checks if List is empty
    public boolean isEmpty() {

            return(head == null);
        }
        
    // Prints every element in the list to screen
    public void display() {

        Node currNode = head; // First node is set to head

        for(int i = 0; currNode != null; i++) { // loop till currNode is not null

            // Display the node's contents
            currNode.display(i);

            // Display next Node
            System.out.println("Next Node is " + currNode.next);

            // Set CurrNode to next Node
            // when currNode.next is null, the loop terminates
            currNode = currNode.next;

            System.out.println();
        }

    }

    public void displayReverse() {

        Node currNode = tail; // First node is set to head

        System.out.println("Displaying Linked List from Back to Front \n");

        for(int i = size-1; currNode != null; i--) { // loop till currNode is not null

            // Display the node's contents
            currNode.display(i);

            // Display next Node
            System.out.println("Previous Node is " + currNode.previous);

            // Set CurrNode to previous Node
            // when currNode.previous is null, the loop terminates
            currNode = currNode.previous;

            System.out.println();
        }
    }

    // Append() adds a new Node to the back/tail of the Linked List
    public void prepend(String dataKey, int dataValue) {

        Node newNode = new Node(dataKey, dataValue);

        if(isEmpty()) {

            tail = newNode;
        } else {

            // List isn't empty, current Head's previous is set to the newNode
            head.previous = newNode;
        }

        // Next pointer of newNode being set to the current Head object
        newNode.next = head;

        // newNode is then set as the current Head
        head = newNode;

        size++;
    }

    // Append() adds a new Node to the back/tail of the Linked List
    public void append(String dataKey, int dataValue) {
        Node newNode = new Node(dataKey, dataValue);

        if(isEmpty()) {

            head = newNode;
        } else {

            // List isn't empty, current Tail's next is set to the newNode
            tail.next = newNode;

            // newNode's prev set to current tail
            newNode.previous = tail;

        }

        // newNode becomes the new Tail
        tail = newNode;

        size++;
    }

    // Inserts node at specific index in the list, node at this index is shifted rightward
    public boolean insertAt(int index, String dataKey, int dataValue) {
        Node newNode = new Node(dataKey, dataValue);

        // current node is set to head, iteration starts from head
        Node current = head;

        for (int i = 0; i != index; i++) {
            current = current.next;
        }

         // Node that comes after current node is set to newNode's next 
           newNode.next = current;
        // The previous reference of the next node of the current node is set to newNode
           current.previous.next = newNode;
            
        //In this way, newNode is inserted between the current node and the current node's next node
        
        // newNode's previous field is set to the current node
        newNode.previous = current.previous;
        current.previous = newNode;

        size++;

        return true;
    }

    // Removes first element/head of the list, sets next element to new head
    public void removeFirst() {

        // Reference to head is set to null in the node after head
        head.next.previous = null;

        // The node after the current head is made the new head
        head = head.next;

        size--;

    }

    // Removes last element/tail of the list, sets previous element to new tail
    public void removeLast() {

        //  Reference to current tail is set to null in the node before the current tail
        tail.previous.next = null;

        // Node before the current tail is set to be the new tail
        tail = tail.previous;

        size--;

    }
    
    // Removes element from given index
    public void removeAt(int index) {
        // current node is set to head, iteration starts from head
        Node current = head;

        if( index >= size) {
            throw new IllegalArgumentException(Integer.toString(index));
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size-1) {
            removeLast();
        } else {

            for(int i = 0; i != index; i++) {
                current = current.next;
            }
    
            // The node after current's prev now points to the prev node of current
            current.next.previous = current.previous;

            // The node before current's next now points to the node the comes after current
            current.previous.next = current.next;


            current = null;

            size--;
            
        }

    }

}

