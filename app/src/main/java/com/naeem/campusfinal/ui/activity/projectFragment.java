package com.naeem.campusfinal.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.naeem.campusfinal.R;
import com.naeem.campusfinal.ui.activity.ActivityFragment;
import com.naeem.campusfinal.ui.activity.CommunityFragment;

public class projectFragment extends Fragment {

private Button eventbtn2,communitybtn2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_project, container, false);

       eventbtn2 = (Button)view.findViewById(R.id.eventbtn2);
       communitybtn2 = (Button)view.findViewById(R.id.communitiesbtn2);

        eventbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ActivityFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container5,fragment).commit();

            }
        });

        communitybtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment2 = new CommunityFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container5,fragment2).commit();

            }
        });
       return view;
    }
}