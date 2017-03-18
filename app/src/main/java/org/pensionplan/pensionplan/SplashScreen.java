package org.pensionplan.pensionplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Realm realm = Realm.getDefaultInstance();
        User user = realm.where(User.class).findFirst();

        User splash = new User();
        splash.name = "anita";
        splash.email = "ani@gmail.com";
        splash.age = 12;

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(splash);
        realm.commitTransaction();


        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                   sleep(3000);
                    Intent intent = new Intent(SplashScreen.this,loginPage.class);

                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}