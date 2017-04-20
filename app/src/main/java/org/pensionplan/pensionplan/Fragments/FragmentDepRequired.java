package org.pensionplan.pensionplan.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.pensionplan.pensionplan.AnsDepositReq;
import org.pensionplan.pensionplan.R;
import org.pensionplan.pensionplan.utilities.PensionModule;

/**
 * Created by owner on 1/31/2017.
 */
public class FragmentDepRequired extends Fragment {

    double inflation = 0.12;
    public static double interest = 0.15;
    public static double annualIncrease = 0.12;
    public static double annualInterest = 0.22;
    public static double McompoundedTimes = 0.25;
    double quartResult;
    double calculatetResult;
    double monthlyDepResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deposit_required, container, false);

        EditText editText = (EditText) view.findViewById(R.id.edit_current);
        EditText editTextOne = (EditText) view.findViewById(R.id.edit_life);
        EditText editTextTwo = (EditText) view.findViewById(R.id.edit_retire);
        EditText editTextThree = (EditText) view.findViewById(R.id.edit_monthly);
        EditText editTextFour = (EditText) view.findViewById(R.id.edit_amount);
        EditText editTextFive = (EditText) view.findViewById(R.id.edit_compounded);
       Button button = (Button) view.findViewById(R.id.calculate_button);

        int currentValue = Integer.parseInt(editText.getText().toString());
        int life =   Integer.parseInt(editTextOne.getText().toString());
        int retireValue =  Integer.parseInt(editTextTwo.getText().toString());
        double monthlyValue =  Double.parseDouble(editTextThree.getText().toString());
        double amountToHeirValue =  Double.parseDouble(editTextFour.getText().toString());
        double compoundedValue =  Double.parseDouble(editTextFive.getText().toString());






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AnsDepositReq.class);
                Bundle paramaters = new Bundle();
                paramaters.putDouble("quart",quartResult);
                paramaters.putDouble("calculate",calculatetResult);
                paramaters.putDouble("monthly",monthlyDepResult);
                
                intent.putExtras(paramaters);
                
                startActivity(intent);


            }
        });


        return view;

    }

}





