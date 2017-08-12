package com.kv.habitatforhumanity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Ken Vonckx on 8/5/2017.
 */

public class Contact extends Fragment{
    private Spinner spinner;
    private ArrayAdapter<CharSequence> adapter;
    private Context thiscontext;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Contact Us");
        spinner = (Spinner)getView().findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(thiscontext, R.array.location_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment contact_frag = null;
                switch (i) {
                    case 0:
                        Toast.makeText(thiscontext, "Please select", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Fragment main_frag = new ContactMain();
                        contact_frag = main_frag;
                        Toast.makeText(thiscontext, adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(thiscontext, adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(thiscontext, adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_LONG).show();
                        break;
                }
                if (contact_frag != null) {
                    FragmentManager contact_mang = getFragmentManager();
                    FragmentTransaction contact_trans = contact_mang.beginTransaction();
                    contact_trans.add(android.R.id.content, contact_frag);
                    contact_trans.replace(android.R.id.content, contact_frag).commit();
                }
                //if (adapterView.getItemAtPosition(i).equals("Main")){
                //Fragment main_frag = new ContactMain();
                //contact_frag = main_frag;
                //FragmentManager main_mang = getFragmentManager();
                //FragmentTransaction main_trans = main_mang.beginTransaction();
                //main_trans.add(android.R.id.content, main_frag);
                //main_trans.commit();
                //Toast.makeText(thiscontext, "should also work", Toast.LENGTH_LONG).show();
                //}
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(thiscontext, "Nothing is selected", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        thiscontext = container.getContext();
        return inflater.inflate(R.layout.contact, container, false);
    }

}
