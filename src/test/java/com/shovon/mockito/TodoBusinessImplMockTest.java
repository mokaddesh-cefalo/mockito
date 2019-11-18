package com.shovon.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedTest_usingMock() {

        ToDoService toDoServiceMock = mock(ToDoService.class);
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoServiceMock);
        List<String> stringList = Arrays.asList("Learn", "Spring", "Dance with Spring");

        when(toDoServiceMock.retrieveTodos("Dummy")).thenReturn(stringList);

        List<String> filteredTodos = toDoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
        assertEquals("Spring", filteredTodos.get(0));
    }

    @Test
    public void usingMockito() {
        ToDoService todoService = Mockito.mock(ToDoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }

    @Test
    public void letsTestDeleteNow() {

        ToDoService todoService = mock(ToDoService.class);

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

        verify(todoService).deleteTodo("Learn to Dance");

        verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

        verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

        verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast

    }

    @Test
    public void captureArgument() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        ToDoService todoService = mock(ToDoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        Mockito.when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

        Mockito.verify(todoService).deleteTodo(argumentCaptor.capture());
        assertEquals("Learn to Dance", argumentCaptor.getValue());
    }
}
