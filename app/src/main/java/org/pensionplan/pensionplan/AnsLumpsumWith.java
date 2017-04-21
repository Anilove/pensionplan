package org.pensionplan.pensionplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnsLumpsumWith extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans_lumpsum_with);


        //  TextView textView = (TextView)findViewById(R.id.life_result);
        TextView textViewTwo = (TextView) findViewById(R.id.lumpsum_result_with);



        Intent getValues = getIntent();
        String lumpsum = getValues.getStringExtra("lumpsum");


        //textView.setText(quart);
        textViewTwo.setText(lumpsum);


    }
}
