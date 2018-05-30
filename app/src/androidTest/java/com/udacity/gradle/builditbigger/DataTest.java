package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.CountDownLatch;

@RunWith(AndroidJUnit4.class)
public class DataTest extends AndroidTestCase{

    @Test
    public void verifyResponse() throws InterruptedException {
        EndpointsAsyncTask test =  new EndpointsAsyncTask();

        final CountDownLatch signal = new CountDownLatch(1);

        test.callback = new EndpointsAsyncTask.Callback() {
            @Override
            public void onPostExecute(String result) {
                assert !result.isEmpty();
                signal.countDown();
            }
        };
        signal.await();
        test.execute(InstrumentationRegistry.getContext()).execute();
    }
}
