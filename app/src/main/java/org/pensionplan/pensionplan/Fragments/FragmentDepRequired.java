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

    double calculatedResult;
    double monthlyDepResult;
    EditText editText, editTextOne, editTextTwo, editTextThree, editTextFour, editTextFive;
    PensionModule pensionModule;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deposit_required, container, false);

        editText = (EditText) view.findViewById(R.id.edit_current);
        editTextOne = (EditText) view.findViewById(R.id.edit_life);
        editTextTwo = (EditText) view.findViewById(R.id.edit_retire);
        editTextThree = (EditText) view.findViewById(R.id.edit_monthly);
        editTextFour = (EditText) view.findViewById(R.id.edit_amount);
        editTextFive = (EditText) view.findViewById(R.id.edit_compounded);
        Button button = (Button) view.findViewById(R.id.calculate_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateResult();

            }
        });

        return view;

    }

    private void calculateResult() {

        int currentAge = Integer.parseInt(editText.getText().toString());
        int lifeExpectancy = Integer.parseInt(editTextOne.getText().toString());
        int retireAge = Integer.parseInt(editTextTwo.getText().toString());
        double monthlyWithdrawal = Double.parseDouble(editTextThree.getText().toString());
        double amountToHeir = Double.parseDouble(editTextFour.getText().toString());
        double compoundedInterest = Double.parseDouble(editTextFive.getText().toString());

       // Log.e("value",currentAge+"V" +retireAge);
        pensionModule = new PensionModule(currentAge,retireAge,lifeExpectancy,monthlyWithdrawal,amountToHeir,compoundedInterest);
        double quarterly = pensionModule.getQuarterly();
        calculatedResult  = pensionModule.calculate();
        monthlyDepResult = pensionModule.getMonthlyDep();

       /* Log.e("quarterlyvalue",quarterly+"V");
        Log.e("quarterlyvalue",calculatedResult+"V");
        Log.e("quarterlyvalue",monthlyDepResult+"V");*/
        Intent intent = new Intent(getActivity(),AnsDepositReq.class);
        intent.putExtra("quart", String.valueOf(quarterly));
        intent.putExtra("calculate", String.valueOf(calculatedResult));
        intent.putExtra("monthly", String.valueOf(monthlyDepResult));
        getActivity().startActivity(intent);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("REGULAR DEPOSIT REQUIRED");
    }
}





