package org.pensionplan.pensionplan;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final String pin = PreferenceManager.getDefaultSharedPreferences(SplashScreen.this).getString("PIN","");
        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                   sleep(3000);

                    if (pin.isEmpty()){
                        Intent intent = new Intent(SplashScreen.this,SignUp.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Intent intent = new Intent(SplashScreen.this,loginPage.class);
                        startActivity(intent);
                        finish();
                    }

                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
