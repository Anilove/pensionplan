package org.pensionplan.pensionplan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.pensionplan.pensionplan.R;
import org.pensionplan.pensionplan.Trustees;
import org.pensionplan.pensionplan.TrusteesListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owner on 2/2/2017.
 */
public class FragmentTrusteeList extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trustees_list,container,false);

        ListView listView = (ListView)view.findViewById(R.id.trusteeList);



        Trustees nameone = new Trustees("PETRA TRUST COMPANY LTD","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees nametwo = new Trustees("METROPOLITAN PENSIONS TRUST GHANA","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees namethree = new Trustees("PENSIONS ALLIANCE TRUST COMPANY","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees namefour = new Trustees("PROVIDENTLIFE TRUST COMPANY","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees namefive = new Trustees("UNIVERSAL PENSIONS MASTER TRUST LTD","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees namesix = new Trustees("SECURE PENSIONS TRUST LTD","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees nameseven = new Trustees("ENTERPRISE TRUSTEES LTD","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees nameeight = new Trustees("UNITED PENSION TRUSTEES LTD","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees namenine = new Trustees("AXIS PENSION TRUST LTD","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees nameten = new Trustees("GENERAL TRUST COMPANY LTD","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees nameeleven = new Trustees("GALCO PENSIONS TRUSTEE LTD","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees nametwelve = new Trustees("NEGOTIATED BENEFITS LTD","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees namethirteen = new Trustees("STALLION TRUST & ADMINISTRATION LTD","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees namefourteen = new Trustees("NTHC TRUSTEES","113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees namefifteen = new Trustees("HEDGE PENSIONS TRUST","113,Airport West,Near Oasis Lodge,Dzorwulu");


        List<Trustees> names = new ArrayList<>();
        names.add(nameone);
        names.add(nametwo);
        names.add(nameone);
        names.add(namethree);
        names.add(namefour);
        names.add(namefive);
        names.add(namesix);
        names.add(nameseven);
        names.add(nameeight);
        names.add(namenine);
        names.add(nameten);
        names.add(nameeleven);
        names.add(nametwelve);
        names.add(namethirteen);
        names.add(namefourteen);
        names.add(namefifteen);

        TrusteesListAdapter trusteesListAdapter = new TrusteesListAdapter(getActivity(), R.layout.trustees_list_item, names);
        listView.setAdapter(trusteesListAdapter);

        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Pension Trustees");
    }
}
