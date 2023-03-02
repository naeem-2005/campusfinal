package com.naeem.campusfinal.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.naeem.campusfinal.R;


public class ActivityFragment extends Fragment {

    private Button projectbtn, eventbtn, communitybtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity, container, false);

        projectbtn = (Button) view.findViewById(R.id.projectbtn);
        eventbtn = (Button) view.findViewById(R.id.eventsbtn);
        communitybtn = (Button) view.findViewById(R.id.communitiesbtn);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#2c2f49"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("My Activity");


        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.profile_notificationbar_color));

        projectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new projectFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.container4, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        communitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment2 = new CommunityFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.container4, fragment2);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        return view;
    }
}