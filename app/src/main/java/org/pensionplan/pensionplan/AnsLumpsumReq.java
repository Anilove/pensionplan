package org.pensionplan.pensionplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnsLumpsumReq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans_lumpsum_req);

       //  TextView textView = (TextView)findViewById(R.id.life_result);
        TextView textViewTwo = (TextView) findViewById(R.id.lump_result);
        TextView textViewThree = (TextView) findViewById(R.id.resultquart);



        Intent getValues = getIntent();
        String calculate = getValues.getStringExtra("calculate");
        String lumpsum = getValues.getStringExtra("lumpsum");


        //textView.setText(quart);
        textViewTwo.setText("GHS" + lumpsum);
        textViewThree.setText("GHS" + calculate);

    }
}
