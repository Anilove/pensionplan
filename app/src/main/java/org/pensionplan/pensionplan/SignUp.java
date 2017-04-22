package org.pensionplan.pensionplan;

import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextname = (EditText) findViewById(R.id.editTextname);
                EditText editTextmail = (EditText) findViewById(R.id.editTextmail);
                EditText editTextpin = (EditText) findViewById(R.id.editTextpin);
                EditText editTextconfpin = (EditText) findViewById(R.id.editTextconfpin);

                String name = editTextname.getText().toString();
                String email = editTextmail.getText().toString();
                String pin = editTextpin.getText().toString();
                String confirmpin = editTextconfpin.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(SignUp.this, "enter your name", Toast.LENGTH_LONG).show();
                    return;
                }
                if (email.isEmpty()) {
                    Toast.makeText(SignUp.this, "enter your email", Toast.LENGTH_LONG).show();
                    return;
                }
                if (pin.isEmpty()) {
                    Toast.makeText(SignUp.this, "enter your pin", Toast.LENGTH_LONG).show();
                    return;
                }
                if (confirmpin.isEmpty()) {
                    Toast.makeText(SignUp.this, "confirm your pin", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!pin.equals(confirmpin)) {
                    Toast.makeText(SignUp.this, "pin not the same", Toast.LENGTH_LONG).show();
                    return;
                }

                PreferenceManager.getDefaultSharedPreferences(SignUp.this).edit().putString("NAME",name).apply();
                PreferenceManager.getDefaultSharedPreferences(SignUp.this).edit().putString("EMAIL",email).apply();
                PreferenceManager.getDefaultSharedPreferences(SignUp.this).edit().putString("PIN",pin).apply();

                startActivity(new Intent(SignUp.this,HomeActivity.class));

                finish();

            }



        });


    }
}
