package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.showjoke.PresentJoke;


public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        getAndDisplayJoke();
    }

    private void getAndDisplayJoke() {
        mProgressBar.setVisibility(View.VISIBLE);

        new GetJoke() {
            @Override
            protected void onPostExecute(String s) {
                if (s != null) {
                    startActivity(PresentJoke.launchIntent(MainActivity.this, s));
                } else {
                    Toast.makeText(MainActivity.this, "Error Something went wrong", Toast.LENGTH_LONG).show();
                }

                mProgressBar.setVisibility(View.GONE);
            }
        }.execute();
    }


}
