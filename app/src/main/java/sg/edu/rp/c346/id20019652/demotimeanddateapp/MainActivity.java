package sg.edu.rp.c346.id20019652.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.buttonReset);
        //Log.i(DEBUG_TEXT, "btn display is clicked");

        Log.i("P04-Test", "inside onCreate method");

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //time: includes hour and minute

                String time = "Time is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                tvDisplay.setText(time);
                Log.i("P04-Test", "btn display is clicked");
                Log.d("P04-Test", "btn display is clicked for debugging message");
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calendar: includes day, month and year

                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();

                String date = "Date is " + day + "/" + month + "/" + year;
                tvDisplay.setText(date);

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set date 1/1/2021
                //set time 14:15 PM

                dp.updateDate(2021, 1, 1);
                tp.setCurrentHour(14);
                tp.setCurrentMinute(15);

                Toast.makeText(MainActivity.this, "Button Reset is long", Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "Button Reset is clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}