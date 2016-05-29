package model;

import java.util.ArrayList;
import java.util.List;

public class TODOList {
    private List<TODO> todos;

    public TODOList() {
        this.todos = new ArrayList<>();
    }

    public TODOList(List<TODO> todoList) {
        this.todos = todoList;
    }

    public List<TODO> getTodos() {
        return todos;
    }

    public void setTodos(List<TODO> todos) {
        this.todos = todos;
    }
}
