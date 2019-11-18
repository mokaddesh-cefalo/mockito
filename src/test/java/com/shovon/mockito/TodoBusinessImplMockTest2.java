package com.shovon.mockito;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

///@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockTest2 {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    ToDoService todoService;

    @InjectMocks
    ToDoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;



    @Test
    public void usingMockito() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }

    @Test
    public void letsTestDeleteNow() {

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

        verify(todoService).deleteTodo("Learn to Dance");

        verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

        verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

        verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast

    }

    @Test
    public void captureArgument() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);
        
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

        Mockito.verify(todoService).deleteTodo(stringArgumentCaptor.capture());
        assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
    }
}
