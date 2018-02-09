package test;

import main.Catch;
import main.DataStore;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatchTest {
    @Test
    public void noException(){
        DataStore ds = new DataStore();
        Catch c = new Catch(ds);
        assertEquals(1, c.doWork());
        assertEquals(1, c.getSuccessCount());
    }

    @Test
    public void withException()throws Exception {
        DataStore ds = mock(DataStore.class);
        when(ds.getBuffer()).thenThrow(IOException.class);
        Catch c = new Catch(ds);
        int ret = c.doWork();
        assertEquals(-1, ret);
        assertEquals(1, c.getFailCount());
    }
}
