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
import org.pensionplan.pensionplan.R;
import org.pensionplan.pensionplan.utilities.PensionModuleTwo;



/**
 * Created by owner on 1/31/2017.
 */
    public class FragmentLumpsumReq extends Fragment {

    double inflation = 0.12;
    public static double interest = 0.15;
    public static double annualIncrease = 0.12;
    public static double annualInterest = 0.22;
    public static double McompoundedTimes = 0.25;

    double calculatedResult;
    double lumpsumDepResult;
    EditText editText, editTextOne, editTextTwo, editTextThree, editTextFour;
    PensionModuleTwo pensionModuleTwo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lumpsum_required, container, false);

        editText = (EditText) view.findViewById(R.id.edit_currentlump);
        editTextOne = (EditText) view.findViewById(R.id.edit_lifelump);
        editTextTwo = (EditText) view.findViewById(R.id.edit_retirelump);
        editTextThree = (EditText) view.findViewById(R.id.edit_monthlylump);
        editTextFour = (EditText) view.findViewById(R.id.edit_compoundedlump);
        Button button = (Button) view.findViewById(R.id.calculate_buttonlump);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateLumpResult();

            }
        });


        return view;

    }

    private void calculateLumpResult() {

        int currentAge = Integer.parseInt(editText.getText().toString());
        int lifeExpectancy = Integer.parseInt(editTextOne.getText().toString());
        int retireAge = Integer.parseInt(editTextTwo.getText().toString());
        double monthlyWithdrawal = Double.parseDouble(editTextThree.getText().toString());
        double compoundedInterest = Double.parseDouble(editTextFour.getText().toString());

        // Log.e("value",currentAge+"V" +retireAge);
        pensionModuleTwo = new PensionModuleTwo(currentAge, retireAge, lifeExpectancy, monthlyWithdrawal, compoundedInterest);
        calculatedResult = pensionModuleTwo.getCalculate();
        lumpsumDepResult = pensionModuleTwo.getLumpsumReq();


        Log.e("quarterlyvalue",calculatedResult+"V");
        Log.e("quarterlyvalue",lumpsumDepResult+"V");
        Intent intent = new Intent(getActivity(),AnsLumpsumReq.class);
        intent.putExtra("calculate", String.valueOf(calculatedResult));
        intent.putExtra("lumpsum", String.valueOf(lumpsumDepResult));

        getActivity().startActivity(intent);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("LUMP SUM REQUIRED");
    }
}