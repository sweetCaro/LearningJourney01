package entity;

public class TodoList {
    private String todoThing;
    private boolean statusOfThing;

    public TodoList(String todoThing, boolean statusOfThing) {
        this.todoThing = todoThing;
        this.statusOfThing = statusOfThing;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "todoThing='" + todoThing + '\'' +
                ", statusOfThing='" + statusOfThing + '\'' +
                '}';
    }

    public String getTodoThing() {
        return todoThing;
    }

    public void setTodoThing(String todoThing) {
        this.todoThing = todoThing;
    }

    public boolean getStatusOfThing() {
        return statusOfThing;
    }

    public void setStatusOfThing(boolean statusOfThing) {
        this.statusOfThing = statusOfThing;
    }
}
