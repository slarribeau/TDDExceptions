package test;

import main.DataStore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataStoreTest {
    @Test
    public void baseTestingGet() throws IOException {
        DataStore ds = new DataStore();
        String s = ds.getBuffer();
        assertEquals("Scott", s);
    }

    @Test
    public void behaviorTesting() throws IOException {
        //http://www.baeldung.com/mockito-verify
        DataStore ds = mock(DataStore.class);
        when(ds.getBuffer()).thenReturn("larribeau");
        String s = ds.getBuffer();
        assertEquals("larribeau",s);
    }

    @Test(expected = IOException.class)
    public void exceptionTesting() throws Exception {
        //http://www.baeldung.com/mockito-verify
        DataStore ds = mock(DataStore.class);
        when(ds.getBuffer()).thenThrow(IOException.class);
        String s = ds.getBuffer();
        fail();
    }
}