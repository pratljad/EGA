package at.ega.appointmenthelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btn_doBackup = (Button) findViewById(R.id.btn_doBackup);
        btn_doBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simulated backup.", Toast.LENGTH_LONG).show();
            }
        });

        Button btn_backToMain = (Button) findViewById(R.id.btn_backToMain);
        btn_backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simulated back to main.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            }
        });

        Spinner calenderSpinner = (Spinner) findViewById(R.id.spinner_calendars);
        List<String> calendarList = new ArrayList<String>();
        calendarList.add("list 1");
        calendarList.add("list 2");
        calendarList.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, calendarList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        calenderSpinner.setAdapter(dataAdapter);
    }
}
