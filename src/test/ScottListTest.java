package test;

import main.ScottList;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ScottListTest {

    @Test
    public void nativeTesting() {
        List<String> scottList = new ScottList();
        assertNull(scottList.get(0));
        assertEquals(1, scottList.size());
    }

    @Test
    public void behaviorTesting() {
        //http://www.baeldung.com/mockito-verify

        List<String> mockedList = mock(ScottList.class);
        verifyZeroInteractions(mockedList);
        int len = mockedList.size();
        assertEquals(0,len);
        verify(mockedList).size(); //Validate that size() was actually called
        int len2 = mockedList.size();
        verify(mockedList, times(2)).size();
    }

    @Test
    public void whenThenTesting() {
        //http://www.baeldung.com/mockito-behavior
        ScottList listMock = mock(ScottList.class);
        when(listMock.add(anyString())).thenReturn(false);
        boolean added = listMock.add(randomAlphabetic(6));
        assertThat(added, is(false));

        when(listMock.get(anyInt())).thenReturn("scott");
        String ret = listMock.get(0);
        assertEquals("scott", ret);
    }

    @Test(expected = IllegalStateException.class)
    public void whenThrowTesting() {
        //http://www.baeldung.com/mockito-behavior
        ScottList listMock = mock(ScottList.class);
        when(listMock.add(anyString())).thenThrow(IllegalStateException.class);
        boolean added = listMock.add(randomAlphabetic(6));
        fail();
    }
}