//Task class
public class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}
//Node class
public class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}
//Todo list class 
public class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addTaskToList(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markTaskCompletedByTitle(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equalsIgnoreCase(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task with title '" + title + "' not found.");
    }

    public void displayAllTasks() {
        Node current = head;
        if (current == null) {
            System.out.println("To-Do List is empty.");
            return;
        }
        while (current != null) {
            Task task = current.task;
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
            System.out.println("----");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ToDoList myToDoList = new ToDoList();
        
        Task task1 = new Task("Buy groceries", "Milk, Bread, Eggs");
        Task task2 = new Task("Read book", "Read 'Effective Java'");
        Task task3 = new Task("Workout", "Go to the gym for an hour");

        myToDoList.addTaskToList(task1);
        myToDoList.addTaskToList(task2);
        myToDoList.addTaskToList(task3);

        System.out.println("All tasks:");
        myToDoList.displayAllTasks();

        System.out.println("\nMarking 'Read book' as completed.");
        myToDoList.markTaskCompletedByTitle("Read book");

        System.out.println("\nAll tasks after marking 'Read book' as completed:");
        myToDoList.displayAllTasks();
    }
}
