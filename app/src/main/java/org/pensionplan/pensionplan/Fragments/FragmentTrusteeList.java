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



        Trustees nameone = new Trustees("PETRA TRUST COMPANY LTD", "113,Airport West,Near Oasis Lodge,Dzorwulu");
        Trustees nametwo = new Trustees("METROPOLITAN PENSIONS TRUST GHANA", "81 Tabon Link,North Ridge Crescent,Accra");
        Trustees namethree = new Trustees("PENSIONS ALLIANCE TRUST COMPANY", "No.3,55A Kakramadu Link,Accra");
        Trustees namefour = new Trustees("PROVIDENTLIFE TRUST COMPANY", "Provident Towers,Ring Road Central,Accra");
        Trustees namefive = new Trustees("UNIVERSAL PENSIONS MASTER TRUST LTD", "762, Kade Ave. Kanda Estate,Accra");
        Trustees namesix = new Trustees("SECURE PENSIONS TRUST LTD", "91,Osu Badu St,Accra");
        Trustees nameseven = new Trustees("ENTERPRISE TRUSTEES LTD", "47,Patrice Lumumba Rd, Airport Res.Area, Accra ");
        Trustees nameeight = new Trustees("UNITED PENSION TRUSTEES LTD", "21, Vanguard House, Independence Avenue Ridge, Accra");
        Trustees namenine = new Trustees("AXIS PENSION TRUST LTD", "4,Ibadan Avenue, East Legon,Accra");
        Trustees nameten = new Trustees("GENERAL TRUST COMPANY LTD", "8,Saflo Link AbelemKpe,Accra");
        Trustees nameeleven = new Trustees("GLICO PENSIONS TRUSTEE LTD", "47,Kwame Nkrumah Avenue Adabraka, Accra");
        Trustees nametwelve = new Trustees("NEGOTIATED BENEFITS LTD", "8,Kakramadu Street,Cantoments,Accra");
        Trustees namethirteen = new Trustees("STALLION TRUST & ADMINISTRATION LTD", "10,Roman RD,Roman Ridge,Accra");
        Trustees namefourteen = new Trustees("NTHC TRUSTEES", "18,Gamel Abdul Nasser Ave. RingWay Estates,Accra");
        Trustees namefifteen = new Trustees("HEDGE PENSIONS TRUST", "National Secretariat,CLOSSAG Ministries,Accra");


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
