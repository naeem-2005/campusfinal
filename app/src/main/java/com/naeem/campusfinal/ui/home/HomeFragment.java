package com.naeem.campusfinal.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.naeem.campusfinal.R;
import com.naeem.campusfinal.authentication.LoginActivity;
import com.naeem.campusfinal.ui.home.project.ProjectActivity;
import com.naeem.campusfinal.ui.home.upcomingevent.UpcomingEventActivity;


public class HomeFragment extends Fragment {

    private ActionBar actionBar;
    private TextView upcoming_more,project_more;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home, container, false);

       upcoming_more = (TextView) view.findViewById(R.id.upcoming_more1);
       project_more = (TextView) view.findViewById(R.id.more_project);


        actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        ColorDrawable colorDrawable  = new ColorDrawable(Color.parseColor("#d3356e"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("Hey User,");

        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.home_notificationbar_color));

        upcoming_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(),UpcomingEventActivity.class);
                startActivity(intent1);
                getActivity().finish();
            }
        });

        project_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), ProjectActivity.class);
                startActivity(intent1);
                getActivity().finish();
            }
        });

        return view;



    }
}