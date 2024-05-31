//node class
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
//LinkedList class
class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a node at a specified position
    public void insertAtPosUnique(int data, int position) {
        Node newNode = new Node(data);
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to delete a node at a specified position
    public void deleteAtPositionUnique(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position or empty list!");
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        current.next = current.next.next;
    }

    // Method to delete a node after a given node
    public void deleteAfterNodeUnique(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("Previous node is null or there is no next node!");
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    // Method to search for a node with a specific value
    public boolean searchNodeUnique(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to display the list
    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
//Stack class using linked list 
class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    // Push operation
    public void pushUnique(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop operation
    public int popUnique() {
        if (top == null) {
            System.out.println("Stack underflow!");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    // Peek operation
    public int peekUnique() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top.data;
    }

    // Method to display the stack
    public void displayStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
//Main Class to Test the Implementation
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtPosUnique(10, 1);
        list.insertAtPosUnique(20, 2);
        list.insertAtPosUnique(30, 3);
        list.displayList();

        list.deleteAtPositionUnique(2);
        list.displayList();

        list.insertAtPosUnique(40, 2);
        list.displayList();

        Node node = new Node(50);
        list.insertAtPosUnique(node.data, 2);
        list.displayList();

        list.deleteAfterNodeUnique(list.head.next);
        list.displayList();

        System.out.println("Search for 30: " + list.searchNodeUnique(30));
        System.out.println("Search for 40: " + list.searchNodeUnique(40));

        Stack stack = new Stack();
        stack.pushUnique(100);
        stack.pushUnique(200);
        stack.pushUnique(300);
        stack.displayStack();

        System.out.println("Pop from stack: " + stack.popUnique());
        stack.displayStack();

        System.out.println("Peek from stack: " + stack.peekUnique());
    }
}
