package com.android.data;

import android.content.Context;
import android.test.InstrumentationTestCase;
import com.android.data.models.Task;

public class BaseTestCase extends InstrumentationTestCase {
    protected Repository<Task> taskRepository;
    private DataStore dataStore;

    @Override
    public void setUp() throws Exception {
        dataStore = new DataStore(getInstrumentation().getContext(), "test.db");
        taskRepository = new Repository<Task>(Task.class, dataStore);
        taskRepository.reset();
    }

    @Override
    protected void tearDown() throws Exception {
        dataStore.close();
        super.tearDown();
    }

    protected void sleepEnoughForAdapterToReQuery() throws InterruptedException {
        Thread.sleep(100);
    }

    protected Context getContext() {
        return getInstrumentation().getContext();
    }
}
