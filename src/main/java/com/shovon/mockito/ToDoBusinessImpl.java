package com.shovon.mockito;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


//TODOService dependency
//TodoBusinessImpl SUT

@Data
@AllArgsConstructor
public class ToDoBusinessImpl {
    private ToDoService toDoService;

    public List<String > retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = toDoService.retrieveTodos(user);

        for(String todo: todos) {
            if(todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }

        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> allTodos = toDoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (!todo.contains("Spring")) {
                toDoService.deleteTodo(todo);
            }
        }
    }

}
