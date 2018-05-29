package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RunWith(AndroidJUnit4.class)
public class DataTest extends AndroidTestCase{

    @Test
    public void verifyResponse(){
        EndpointsAsyncTask test =  new EndpointsAsyncTask();
        test.execute(InstrumentationRegistry.getContext());
        String joke = null;
        try {
            joke = test.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        assert !joke.isEmpty();
    }
}
