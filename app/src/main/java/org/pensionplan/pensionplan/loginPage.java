package org.pensionplan.pensionplan;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class loginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        final Button login =(Button)findViewById(R.id.log);
        TextView textView = (TextView)findViewById(R.id.signup);

        final Intent intent = new Intent(loginPage.this,SignUp.class);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final EditText editTextPin =(EditText)findViewById(R.id.pass1);
                String pinEntered = editTextPin.getText().toString();
                final String pin = PreferenceManager.getDefaultSharedPreferences(loginPage.this).getString("PIN","");
                if(pinEntered.length() <4){
                    Toast.makeText(loginPage.this,"Please enter 4 digit pin", Toast.LENGTH_LONG).show();
                } else if (pinEntered.equalsIgnoreCase(pin)){
                    editTextPin.setText("");
                    startActivity(new Intent(loginPage.this, HomeActivity.class));
                }else {
                    editTextPin.setText("please Sign Up");
                }
            }
        });


    }



}
