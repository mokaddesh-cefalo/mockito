package com.shovon.mockito;

import java.util.List;

//create TodoServiceStub
//test TodoBusinessImpl using TodoServiceStub
public interface ToDoService {
    List<String> retrieveTodos(String user);
    void deleteTodo(String todo);
}
