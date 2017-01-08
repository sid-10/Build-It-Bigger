package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class GetJokeTest extends AndroidTestCase {

    public void testJokeDownload() {

        try {
            GetJoke task = new GetJoke();
            task.execute();
            String joke = task.get(30, TimeUnit.SECONDS);

            assertThat(joke, notNullValue());
            assertTrue(joke.length() > 0);

        } catch (Exception e) {
            fail("Operation timed out");
        }
    }

}
