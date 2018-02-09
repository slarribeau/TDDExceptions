package main;

import java.io.IOException;
import java.lang.reflect.Array;

public class DataStore {

    public String getBuffer() throws IOException {
        if (1==0) {
            throw new IOException();
        }
        return "Scott";
    }

}
