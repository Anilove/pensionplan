package org.pensionplan.pensionplan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pensionplan.pensionplan.PensionModule;
import org.pensionplan.pensionplan.R;

/**
 * Created by owner on 1/31/2017.
 */
public class FragmentDepRequired extends Fragment {
    private double BeginningValue = 0.0;
    private double lifeSpan = 20.0;
    private double compoundedTimes = 0.25;
    private double interestRate = 0.15;
    private double annualIincrease = 0.12;
    private double inflation = 0.12;


    public FragmentDepRequired() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deposit_required,container,false);



        calculate(30000.0,23,60,2000.0);
        return view;
    }

    private void calculate(double amountToHeir,int currentAge,int retireAge,double monthlyWith){

        Log.e("RESULT_IN_FR",String.valueOf(BeginningValue));
        double finalResult = 0.0;
        BeginningValue = PensionModule.getBeginning(amountToHeir,currentAge,retireAge,monthlyWith,interestRate,compoundedTimes);
        double currentWith = PensionModule.getWithdrawal(annualIincrease,retireAge,inflation,monthlyWith,currentAge);
        while (lifeSpan >= 1.0){
            double withdrawal = currentWith / annualIincrease;
            //finalResult = BeginningValue;
            double NewPrewithdrawal = BeginningValue + withdrawal;
            finalResult = NewPrewithdrawal/(1+(interestRate * compoundedTimes));
            Log.e("SPAN",String.valueOf(finalResult));
            BeginningValue = finalResult;
            currentWith = withdrawal;
            lifeSpan = lifeSpan - compoundedTimes;
        }
    }


}




