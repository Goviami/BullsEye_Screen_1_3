package com.example.xzbkcc.bullseye1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class RegisterPhoneNo extends Activity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerCountryList;
    EditText editTextPhoneNumber;
    Button nextButton;
    private String[] country = { "United States", "India", "United Kingdom", "Brazil",
            "Mexico", "Australia", "Japan", "China",
            "South Korea" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_phone_no);

        editTextPhoneNumber = (EditText)findViewById(R.id.phoneNumber);
        spinnerCountryList = (Spinner)findViewById(R.id.spinnerCountry);

        ArrayAdapter<String> adapter_country = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, country);
        adapter_country.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCountryList.setAdapter(adapter_country);
        spinnerCountryList.setOnItemSelectedListener(this);

        editTextPhoneNumber = (EditText)findViewById(R.id.phoneNumber);
        nextButton =(Button)findViewById(R.id.buttonNext);

        //This part is used to display the terms and condition from website.
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                if (validatePhoneEmail()) {
                    Intent webLogin = new Intent(getApplicationContext(), ProfileInfo.class);
                    webLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(webLogin);
                }
            }
        });
    }

    public boolean validatePhoneEmail()
    {
        editTextPhoneNumber.setError(null);

        String phoneNo = editTextPhoneNumber.getText().toString();

        if (!TextUtils.isEmpty(phoneNo) && !isPhoneNoValid(phoneNo))
        {
            editTextPhoneNumber.setError("Please Enter a valid phone number");
            return false;
        }

        if (TextUtils.isEmpty(phoneNo))
        {
            editTextPhoneNumber.setError("This field is required");
            return false;
        }

        return true;
    }

    public boolean isPhoneNoValid(String mPhoneNo)
    {
        return mPhoneNo.length() == 10;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        spinnerCountryList.setSelection(position);
        String selCountry = (String) spinnerCountryList.getSelectedItem();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register_phone_no, menu);
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
