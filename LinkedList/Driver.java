package LinkedList;

public class Driver {
    public static void main(String[] args) {
        DoublyLinkedList theLinkedList = new DoublyLinkedList();

        theLinkedList.append("Mango", 1);
        theLinkedList.append("Banana", 2);
        theLinkedList.append("Orange", 3);
        theLinkedList.append("Pineapple", 4);
        theLinkedList.append("Apple", 5);


        theLinkedList.display();

        System.out.println();

        System.out.print("Linked List Size : "+theLinkedList.size);

        System.out.println();
        theLinkedList.removeAt(2);
        theLinkedList.displayReverse();

        
    }
}
