package com.example.slinder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import com.example.aircalendar.AirCalendarDatePickerActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReservationActivity extends AppCompatActivity {

    InputMethodManager imm;
    EditText et_txt;
    RelativeLayout a1, a2, a3, a5;
    LinearLayout a4;
    CheckBox cb1, cb2, cb3;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String UserId;

    String start, end;
    String result = " ";

    EditText user, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        a1 = (RelativeLayout)findViewById(R.id.a1);
        a2 = (RelativeLayout)findViewById(R.id.a2);
        a3 = (RelativeLayout)findViewById(R.id.a3);
        a4 = (LinearLayout)findViewById(R.id.a4);
        a5 = (RelativeLayout)findViewById(R.id.a5);

        et_txt = (EditText)findViewById(R.id.ed_txt);
        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        TextView txt_start = (TextView)findViewById(R.id.start);
        TextView txt_end = (TextView)findViewById(R.id.end);

        Intent intent = getIntent();

        start = intent.getExtras().getString("start");
        txt_start.setText(start);
        end = intent.getExtras().getString("end");
        txt_end.setText(end);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);


        a1.setOnClickListener(myClickListener);
        a2.setOnClickListener(myClickListener);
        a3.setOnClickListener(myClickListener);
        a4.setOnClickListener(myClickListener);
        a5.setOnClickListener(myClickListener);

        //user = (EditText)findViewById(R.id.)

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("DataUsers");
        UserId = mFirebaseDatabase.push().getKey();



        if(cb1.isChecked()) result += cb1.getText().toString();
        if(cb2.isChecked()) result += cb2.getText().toString();
        if(cb3.isChecked()) result += cb3.getText().toString();

    }

    public void addDate(String startdate, String enddate, String s){

        User dates = new User(startdate, enddate, s);
        mFirebaseDatabase.child("Dates").child(UserId).setValue(dates);
    }

//    public void checkGroup(String s){
//        User group = new User(s);
//        mFirebaseDatabase.child("Dates").child(UserId).setValue(group);
//    }

//    public void updateDate(String startdate, String enddate){
//
//        User dates = new User(startdate, enddate);
//        mFirebaseDatabase.child("Dates").child(UserId).child("User").setValue();
//    }

    public void insertData(View view){

        addDate(start.trim(),end.trim(), result.trim());


    }


    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            hideKeyboard();
            switch (view.getId()){
                case R.id.a1 :
                    break;

                case R.id.a2 :
                    break;

                case R.id.a3 :
                    break;

                case R.id.a4 :
                    break;

                case R.id.a5 :
                    break;
            }
        }
    };

    private void hideKeyboard(){
        imm.hideSoftInputFromWindow(et_txt.getWindowToken(), 0);
    }






}
