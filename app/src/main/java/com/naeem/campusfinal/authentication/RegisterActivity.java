package com.naeem.campusfinal.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.naeem.campusfinal.R;

import java.lang.reflect.Array;

public class RegisterActivity extends AppCompatActivity {

    private Spinner classspinner;
    private TextView loginbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String[] selectclass={"select course","BA-1","BA-2","BA-3","BCA-1","BCA-2","BCA-3","B.Com-1",
                "B.Com-2","B.Com-3","B.Sc-1","B.Sc-2","B.Sc-3"};
        classspinner=findViewById(R.id.select_class);
        loginbutton=findViewById(R.id.login_button);


        getSupportActionBar().setTitle("Registration");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.register_notificationbar_color));

        ColorDrawable colorDrawable  = new ColorDrawable(Color.parseColor("#671935"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,selectclass);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classspinner.setAdapter(adapter);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        classspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}