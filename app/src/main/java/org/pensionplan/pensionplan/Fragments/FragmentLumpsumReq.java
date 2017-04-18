package org.pensionplan.pensionplan.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import org.pensionplan.pensionplan.AnsLumpsumReq;
import org.pensionplan.pensionplan.R;

/**
 * Created by owner on 1/31/2017.
 */
public class FragmentLumpsumReq extends Fragment{
    public FragmentLumpsumReq() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lumpsum_required,container,false);
        EditText editText = (EditText) view.findViewById(R.id.edit_current);
        //EditText editTextOne = (EditText) view.findViewById(R.id.edit_life);
        EditText editTextTwo = (EditText) view.findViewById(R.id.edit_retire);
        EditText editTextThree = (EditText) view.findViewById(R.id.edit_monthly);
        EditText editTextFour = (EditText) view.findViewById(R.id.edit_amount);
        EditText editTextFive = (EditText) view.findViewById(R.id.edit_compounded);
        Button button = (Button) view.findViewById(R.id.calculate_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AnsLumpsumReq.class);
                startActivity(intent);


            }
        });


        return view;

    }

}
