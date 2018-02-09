package main;

import java.io.IOException;

public class Catch {
    private DataStore ds;
    private int successCount;
    private int failCount;

    public int doWork() {
        try {
            String s = ds.getBuffer();
            successCount++;
            return 1;
        } catch (IOException e) {
            System.out.println("Something went wrong!");
            failCount++;
            return -1;
        }
    }

    public Catch(DataStore ds) {
        this.ds = ds;
        failCount = 0;
        successCount = 0;
    }
    public int getFailCount() {
        return failCount;
    }

    public int getSuccessCount() {
        return successCount;
    }
}
