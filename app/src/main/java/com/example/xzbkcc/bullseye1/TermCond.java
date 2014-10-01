package com.example.xzbkcc.bullseye1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class TermCond extends Activity {
    public static final String MyPreferences = "MyPrefs";
    public static final Boolean FirstTime = true;
    public static final String indFirst = "indFirstKey";

    SharedPreferences sharedPreferencesVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_cond);

        sharedPreferencesVal = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        if (sharedPreferencesVal.contains(indFirst))
        {
            Intent verifyPhoneNo = new Intent(getApplicationContext(), RegisterPhoneNo.class);
            verifyPhoneNo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(verifyPhoneNo);
        }
    }

    public void onClickAgree(View view)
    {
        SharedPreferences.Editor editor = sharedPreferencesVal.edit();
        editor.putBoolean(indFirst, FirstTime);

        Intent verifyPhoneNo = new Intent(getApplicationContext(), RegisterPhoneNo.class);
        verifyPhoneNo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(verifyPhoneNo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.term_cond, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}