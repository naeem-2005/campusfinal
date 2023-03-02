package com.naeem.campusfinal.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.naeem.campusfinal.R;

public class CommunityFragment extends Fragment {

    private Button eventbtn3,projectbtn3;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_community, container, false);

        eventbtn3 = (Button)view.findViewById(R.id.eventsbtn3);
        projectbtn3 = (Button)view.findViewById(R.id.projectbtn3);

        eventbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ActivityFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container6,fragment).commit();

            }
        });

        projectbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment2 = new projectFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container6,fragment2).commit();

            }
        });

        return view;
    }
}