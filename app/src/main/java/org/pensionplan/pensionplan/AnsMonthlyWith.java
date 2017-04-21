package org.pensionplan.pensionplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnsMonthlyWith extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans_monthly_with);


        //  TextView textView = (TextView)findViewById(R.id.life_result);
        TextView textViewTwo = (TextView) findViewById(R.id.result_with);
        TextView textViewThree = (TextView) findViewById(R.id.result_lump);



        Intent getValues = getIntent();
        String monthly = getValues.getStringExtra("monthly");
        String lumpsum = getValues.getStringExtra("lumpsum");


        //textView.setText(quart);
        textViewTwo.setText(monthly);
        textViewThree.setText(lumpsum);

    }
}
