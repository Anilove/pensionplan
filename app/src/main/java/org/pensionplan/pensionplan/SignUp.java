package org.pensionplan.pensionplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        EditText editText = (EditText) findViewById(R.id.editTextname);
        EditText editTextone = (EditText) findViewById(R.id.editTextmail);
        EditText editTexttwo = (EditText) findViewById(R.id.editTextpin);
        EditText editTextthree = (EditText) findViewById(R.id.editTextconfpin);
        Button button = (Button)findViewById(R.id.button);




        

    }
}
