package org.pensionplan.pensionplan.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.pensionplan.pensionplan.AnsLumpsumReq;
import org.pensionplan.pensionplan.AnsLumpsumWith;
import org.pensionplan.pensionplan.R;
import org.pensionplan.pensionplan.utilities.LumpsumWithdrawal;
import org.pensionplan.pensionplan.utilities.PensionModuleTwo;

/**
 * Created by owner on 1/31/2017.
 */
public class FragmentLumpsumWithdrawal extends Fragment{


    double inflation = 0.12;
    public static double interest = 0.15;
    public static double annualIncrease = 0.12;
    public static double annualInterest = 0.22;
    public static double McompoundedTimes = 0.25;


    double lumpsumWithResult;
    EditText editText, editTextOne, editTextTwo, editTextThree, editTextFour;
    LumpsumWithdrawal lumpsumWithdrawal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lumpsum_withdrawal,container,false);

        editText = (EditText) view.findViewById(R.id.edit_current);
        editTextOne = (EditText) view.findViewById(R.id.edit_life);
         editTextTwo = (EditText) view.findViewById(R.id.edit_retire);
       editTextThree = (EditText) view.findViewById(R.id.edit_amount);
        editTextFour = (EditText) view.findViewById(R.id.edit_compounded);
        Button button = (Button) view.findViewById(R.id.calculate_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateLumpWithResult();

            }
        });
        return view;

    }


    private void calculateLumpWithResult() {

        int currentAge = Integer.parseInt(editText.getText().toString());
        int lifeExpectancy = Integer.parseInt(editTextOne.getText().toString());
        int retireAge = Integer.parseInt(editTextTwo.getText().toString());
        double amountDep = Double.parseDouble(editTextFour.getText().toString());
        double  compoundedInterest= Double.parseDouble(editTextFour.getText().toString());

        // Log.e("value",currentAge+"V" +retireAge);
        lumpsumWithdrawal = new LumpsumWithdrawal(currentAge, retireAge, lifeExpectancy, amountDep,compoundedInterest);
        lumpsumWithResult = lumpsumWithdrawal.getCurrentequivalent();




        Intent intent = new Intent(getActivity(),AnsLumpsumWith.class);
        intent.putExtra("lumpsum", String.valueOf(lumpsumWithResult));

        getActivity().startActivity(intent);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("LUMP SUM WITHDRAWAL");
    }
}
