package com.shovon.mockito;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void test() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @Test
    public void test_returnMultipleValues() {
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    public void testMockList_get_returnMultipleValues() {
        List listMock = mock(List.class);

        when(listMock.get(anyInt())).thenReturn("in28min");

        assertEquals("in28min", listMock.get(0));
        assertEquals("in28min", listMock.get(1));

        assertNotNull(listMock.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void testMockList_get_exception() {
        List listMock = mock(List.class);

        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

        listMock.get(1);
    }
}
