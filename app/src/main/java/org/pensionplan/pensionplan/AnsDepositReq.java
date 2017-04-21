package org.pensionplan.pensionplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.pensionplan.pensionplan.utilities.PensionModule;

public class AnsDepositReq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans_deposit_req);

        // TextView textView = (TextView)findViewById(R.id.result_textone);
        TextView textViewTwo = (TextView) findViewById(R.id.result_texttwo);
        TextView textViewThree = (TextView) findViewById(R.id.result_textthree);
        TextView textViewFour = (TextView) findViewById(R.id.result_textfour);


        Intent getValues = getIntent();
        String quart = getValues.getStringExtra("quart");
        String calculate = getValues.getStringExtra("calculate");
        String monthly = getValues.getStringExtra("monthly");

        //textView.setText(quart);
        textViewTwo.setText(monthly);
        textViewThree.setText(calculate);
        textViewFour.setText(quart);

        // How to call pension module
        //PensionModule pensionModule = new PensionModule(23, 60, 80, 2000, 30000, 4);
    }
}
