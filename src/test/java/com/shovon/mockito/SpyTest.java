package com.shovon.mockito;

import com.sun.xml.bind.v2.TODO;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {
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

        ToDoBusinessImpl toDoBusiness = spy(todoBusinessImpl);
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        List<String> todos =
                toDoBusiness.retrieveTodosRelatedToSpring("Ranga");

        assertEquals(2, todos.size());
        verify(toDoBusiness).retrieveTodosRelatedToSpring("Ranga");

        when(toDoBusiness.retrieveTodosRelatedToSpring("Ranga")).thenReturn(new ArrayList<>());

        todos = toDoBusiness.retrieveTodosRelatedToSpring("Ragna");

        assertEquals(0, todos.size());
        verify(toDoBusiness, times(2)).retrieveTodosRelatedToSpring("Ranga");
    }
}
