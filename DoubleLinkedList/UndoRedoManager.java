package DoubleLinkedList;

public class UndoRedoManager<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> current;

    public void createLinkedList(T value) {
        DoubleNode<T> node = new DoubleNode<>();
        node.value = value;
        node.previous = null;
        node.next = null;
        head = node;
        current = node;
    }

    public void save(T value) {
        if (head == null) {
            createLinkedList(value);
            return;
        }

        DoubleNode<T> node = new DoubleNode<>();
        node.value = value;
        
        node.previous = current;
        node.next = null;

        current.next = node;
        current = node;
    }

    public void undo() {
        if (current != null && current.previous != null) {
            current = current.previous;
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public T getCurrentState() {
        if (current != null) {
            return current.value;
        }
        return null;
    }

    public void printAllStates() {
        DoubleNode<T> temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.print("[" + temp.value + "] ");
            } else {
                System.out.print(temp.value + " ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
