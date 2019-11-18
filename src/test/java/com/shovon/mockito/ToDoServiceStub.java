package com.shovon.mockito;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements ToDoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn", "Spring", "Dance with Spring");
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
