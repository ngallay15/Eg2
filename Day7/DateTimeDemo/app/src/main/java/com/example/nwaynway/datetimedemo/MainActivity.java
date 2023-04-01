

package com.example.nwaynway.datetimedemo;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView lblDateAndTime;
    Calendar myCalendar=Calendar.getInstance();

    TimePicker time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblDateAndTime=(TextView)findViewById(R.id.lbDateTime);

        time=(TimePicker)findViewById(R.id.timePicker);
        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String newTime="Time\n"+hourOfDay+":"+minute;
                lblDateAndTime.setText(newTime);
            }
        });

        Button btnDate=(Button)findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this,
                        datePicker,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)
                        );

                datePickerDialog.show();
            }
        });


    }

    DatePickerDialog.OnDateSetListener datePicker=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR,year);
            myCalendar.set(Calendar.MONTH,month);
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

            Date date=myCalendar.getTime();

            String strDate= DateFormat.getDateInstance().format(date);
            String strDateTime=DateFormat.getDateTimeInstance().format(date);

            lblDateAndTime.setText(strDate+"\n"+strDateTime);
        }
    };
}
