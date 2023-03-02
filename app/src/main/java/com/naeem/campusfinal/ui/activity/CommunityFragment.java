package com.naeem.campusfinal.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.naeem.campusfinal.R;
import com.naeem.campusfinal.ui.home.project.ProjectActivity;

public class CommunityFragment extends Fragment {

    private Button eventbtn3,projectbtn3;
    private TextView joinCommunity;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_community, container, false);

        eventbtn3 = (Button)view.findViewById(R.id.eventsbtn3);
        projectbtn3 = (Button)view.findViewById(R.id.projectbtn3);

        joinCommunity = (TextView)view.findViewById(R.id.joinCommunity);

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

        joinCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Community Section", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity(), ProjectActivity.class);
//                startActivity(intent);
//                getActivity().finish();
            }
        });

        return view;
    }

}