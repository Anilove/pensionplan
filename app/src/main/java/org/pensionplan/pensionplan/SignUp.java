package org.pensionplan.pensionplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();

        User user = realm.where(User.class).findFirst();

        User userone = new User();
        userone.name = "anita";
        userone.email = "ani@gmail.com";
        userone.password = 1235;

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(userone);
        realm.commitTransaction();


        EditText editText = (EditText) findViewById(R.id.editTextname);
        EditText editTextone = (EditText) findViewById(R.id.editTextmail);
        EditText editTexttwo = (EditText) findViewById(R.id.editTextpin);
        EditText editTextthree = (EditText) findViewById(R.id.editTextconfpin);
        Button button = (Button)findViewById(R.id.button);




        

    }
}
