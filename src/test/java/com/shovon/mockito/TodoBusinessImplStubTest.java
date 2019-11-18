package com.shovon.mockito;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodosRelatedTest_usingStub() {

        ToDoService toDoServiceStub = new ToDoServiceStub();
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoServiceStub);

        List<String> filteredTodos = toDoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
        assertEquals("Spring", filteredTodos.get(0));
    }

    @Test
    public void testRetrieveTodosRelatedTest_usingStub2() {

        ToDoService toDoServiceStub = new ToDoServiceStub();
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoServiceStub);

        List<String> filteredTodos = toDoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
        assertEquals("Spring", filteredTodos.get(0));
    }
}
