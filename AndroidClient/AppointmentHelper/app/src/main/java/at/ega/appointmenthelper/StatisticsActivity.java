package at.ega.appointmenthelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import at.ega.appointmenthelper.DomainClasses.ExampleClass;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Button btn_backToMain = (Button) findViewById(R.id.btn_backToCalendar);
        btn_backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simulated back to Calendar.", Toast.LENGTH_LONG).show();
                //attemptLogin();
                startActivity(new Intent(StatisticsActivity.this, MainActivity.class));
            }
        });
/*
        LineChart chart = (LineChart) findViewById(R.id.chart);

        ExampleClass[] dataObjects = new ExampleClass[20];
        dataObjects[0] = new ExampleClass(0,1);
        dataObjects[2] = new ExampleClass(1,1);
        dataObjects[3] = new ExampleClass(2,2);
        dataObjects[4] = new ExampleClass(3,1);

        ArrayList<Entry> entries = new ArrayList<Entry>();

        for (ExampleClass data : dataObjects) {
        //for(int i=0; i<=10; i++){

            // turn your data into Entry objects
            entries.add(new Entry(data.getValueX(), data.getValueY()));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(5);
        dataSet.setColor(2222); // styling, ...

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
        */
    }
}
