package DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.save("1");
        manager.save("2");
        manager.save("3");

        manager.printAllStates();

        manager.undo();
        
        manager.printAllStates();

        manager.undo();
        manager.printAllStates();

        manager.save("0"); // clear
        manager.printAllStates();

        manager.redo();
        manager.printAllStates();
    }
}
