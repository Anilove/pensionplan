package org.pensionplan.pensionplan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pensionplan.pensionplan.R;

/**
 * Created by owner on 1/31/2017.
 */
public class FragmentDepRequired extends Fragment {
    public FragmentDepRequired() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deposit_required,container,false);
        return view;
    }
}
