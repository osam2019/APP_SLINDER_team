package com.example.slinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.aircalendar.AirCalendarDatePickerActivity;
import com.example.aircalendar.core.AirCalendarIntent;
import com.example.aircalendar.core.AirMonthAdapter;
import com.example.aircalendar.core.DatePickerController;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements DatePickerController {



    public final static int REQUEST_CODE = 1;
    private BackPressCloseHandler backPressCloseHandler;

    Button select;
    String start, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backPressCloseHandler = new BackPressCloseHandler(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);



        select = (Button)findViewById(R.id.rl_done_btn);

        AirCalendarIntent intent = new AirCalendarIntent(this);

        //intent.setSelectButtonText("일정 선택 완료");
        //intent.setResetBtnText("Reset");
        intent.setWeekStart(Calendar.MONDAY);
//        ArrayList<String> weekDay = new ArrayList<>();
//        weekDay.add("M");
//        weekDay.add("T");
//        weekDay.add("W");
//        weekDay.add("T");
//        weekDay.add("F");
//        weekDay.add("S");
//        weekDay.add("S");
//        intent.setCustomWeekDays(weekDay);
//        intent.setWeekDaysLanguage(AirCalendarIntent.Language.EN);
//        intent.isSingleSelect(false);
//        intent.isBooking(false); // DEFAULT false
//        intent.isSelect(true); // DEFAULT false
//        intent.setBookingDateArray();
//        intent.setStartDate(2017, 12, 1);
//        intent.setEndDate(2017, 12, 1);
//        intent.isMonthLabels(false);
//        intent.setActiveMonth(3);
//        intent.setStartYear(2018);
//        intent.setMaxYear(2030);

        startActivityForResult(intent, REQUEST_CODE);


        /*select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReservationActivity.class);
                startActivityForResult(intent, REQUEST_CODE);


            }
        });*/

    }

    public void showNotificaion(View view){
        Intent intent = new Intent(this,NotificationActivity.class);
        startActivity(intent);
        finish();
    }

    /*@Override
    public void onBackPressed(){
        backPressCloseHandler.onBackPressed();
    }*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
//            AirCalendarDatePickerActivity.RESULT_SELECT_START_DATE
//            AirCalendarDatePickerActivity.RESULT_SELECT_END_DATE
//            AirCalendarDatePickerActivity.RESULT_SELECT_START_VIEW_DATE
//            AirCalendarDatePickerActivity.RESULT_SELECT_END_VIEW_DATE
//            AirCalendarDatePickerActivity.RESULT_FLAG
//            AirCalendarDatePickerActivity.RESULT_TYPE
//            AirCalendarDatePickerActivity.RESULT_STATE

            if(data != null){
                Toast.makeText(this, "Select Date range : " + data.getStringExtra(AirCalendarDatePickerActivity.RESULT_SELECT_START_DATE) + " ~ " + data.getStringExtra(AirCalendarDatePickerActivity.RESULT_SELECT_END_DATE), Toast.LENGTH_SHORT).show();
            }

            start = data.getStringExtra(AirCalendarDatePickerActivity.RESULT_SELECT_START_DATE);
            end = data.getStringExtra(AirCalendarDatePickerActivity.RESULT_SELECT_END_DATE);
        }
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReservationActivity.class);
                intent.putExtra("start",start);
                intent.putExtra("end",end);

                startActivityForResult(intent, REQUEST_CODE);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getMaxYear() {
        return 0;
    }

    @Override
    public void onDayOfMonthSelected(int year, int month, int day) {

    }

    @Override
    public void onDateRangeSelected(AirMonthAdapter.SelectedDays<AirMonthAdapter.CalendarDay> selectedDays) {

    }





}
