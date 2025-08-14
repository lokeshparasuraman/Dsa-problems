package Oops.LinkedLists;

public class ListNode {
    private Node head;
    private Node tail;
    private int size;

    public ListNode() {
        this.size = 0;
    }
    Node getMid(Node head){
        Node midPrev=null;
        while(head!=null&& head.next!=null){
            midPrev=(midPrev==null)?head:midPrev.next;
            head=head.next.next;
        }
        Node mid=midPrev.next;
        midPrev.next=null;
        return mid;
    }

    public Node get(int val) {
        Node n = head;
        for (int i = 0; i < val; i++) {
            n = n.next;
        }
        return n;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertEnd(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtIndex(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertEnd(val);
            return;
        }
        try {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(val, temp.next);
            temp.next = newNode;
            size++;
        } catch (NullPointerException e) {
            System.out.println("Target index is larger than size of the list so i will add at the end of the list");
            insertEnd(val);
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void deleteFirst() {
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    public void deleteLast() {
        if (size <= 1) {
            deleteFirst();
            return;
        }
        tail = get(size - 2);
        tail.next = null;
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
        try {
            Node prev = head;
            prev = get(index - 1);
            prev.next = prev.next.next;
            size--;
        } catch (NullPointerException e) {
            System.out.println("Can't delete a value does not exist in List!");
        }
    }

    public void insertRec(int val, int index) {
        head = insertRc(val, index, head);
    }

    private Node insertRc(int val, int index, Node node) {

        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRc(val, index - 1, node.next);
        return node;
    }

    public void duplicates() {
        Node node = head;

        while (node.next!=null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            }
            else {
                node = node.next;
            }

        }
        tail = node;
        tail.next = null;
    }


    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
