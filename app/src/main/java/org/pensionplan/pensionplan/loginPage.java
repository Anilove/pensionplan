package org.pensionplan.pensionplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class loginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);



        final EditText Pin =(EditText)findViewById(R.id.pass1);

        final Button login =(Button)findViewById(R.id.log);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(Pin.getText().toString().length() <4){
                    Toast.makeText(loginPage.this,"Please enter 4 digit pin", Toast.LENGTH_LONG).show();
                }

                else{
                    Pin.setText("");
                    startActivity(new Intent(loginPage.this, HomeActivity.class));
                }
            }
        });


    }



}
