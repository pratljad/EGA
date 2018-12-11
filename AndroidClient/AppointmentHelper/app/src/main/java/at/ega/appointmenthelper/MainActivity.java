package at.ega.appointmenthelper;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import at.ega.appointmenthelper.DomainClasses.ExampleClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // Set up the login form.
        init();



    }
    private void init(){
        Button btn_changeToStatistics = (Button) findViewById(R.id.btn_statistics);
        btn_changeToStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simulated change to statistics.", Toast.LENGTH_LONG).show();
                //attemptLogin();
                startActivity(new Intent(MainActivity.this, StatisticsActivity.class));
                // setContentView(R.layout.activity_main);
            }
        });

        Button btn_changeToSettings = (Button) findViewById(R.id.btn_settings);
        btn_changeToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simulated cchange to settings", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        LineChart chart = (LineChart) findViewById(R.id.chart);
        chart.getXAxis().setLabelCount(11,  true);
        chart.getXAxis().setAxisMinimum(0);
        chart.getXAxis().setAxisMaximum(10);

        chart.getAxisLeft().setLabelCount(11,  true);
        chart.getAxisLeft().setAxisMinimum(0);
        chart.getAxisLeft().setAxisMaximum(10);

        chart.setScaleEnabled(false);
        chart.getAxisRight().setDrawLabels(false);
        chart.getAxisRight().setEnabled(false);
        chart.getDescription().setText("Tage");

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);


        ExampleClass[] dataObjects = new ExampleClass[5];
        dataObjects[0] = new ExampleClass(0,1);
        dataObjects[1] = new ExampleClass(1,1);
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
        dataSet.setColor(10);
        dataSet.setFillColor(10);
        dataSet.setCircleRadius(7);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }

}
