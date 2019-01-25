package at.ega.appointmenthelper;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;

import org.mortbay.jetty.ResourceCache;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import at.ega.appointmenthelper.DataAccess.CalendarDataAccess;
import at.ega.appointmenthelper.DomainClasses.ExampleClass;

public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener {

    com.google.api.services.calendar.Calendar mService;

    GoogleAccountCredential credential;
    private TextView mStatusText;
    private TextView mResultsText;
    final HttpTransport transport = AndroidHttp.newCompatibleTransport();
    final JsonFactory jsonFactory = GsonFactory.getDefaultInstance();

    static final int REQUEST_ACCOUNT_PICKER = 1000;
    static final int REQUEST_AUTHORIZATION = 1001;
    static final int REQUEST_GOOGLE_PLAY_SERVICES = 1002;
    private static final String PREF_ACCOUNT_NAME = "accountName";
    private static final String[] SCOPES = { CalendarScopes.CALENDAR_READONLY };

    ArrayList<Entry> entries;
    ExampleClass[] dataObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        init();
    }


    private void init(){
        loadButtons();
        loadCharts();
    }



    private void loadButtons(){
        Button btn_demo = (Button) findViewById(R.id.btn_demoSwitch);
        btn_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginGoogleActivity.class));
            }
        });


        Button btn_changeToStatistics = (Button) findViewById(R.id.btn_statistics);
        btn_changeToStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Simulated change to statistics.", Toast.LENGTH_LONG).show();
                //attemptLogin();
                startActivity(new Intent(MainActivity.this, StatisticsActivity.class));
                // setContentView(R.layout.activity_main);
            }
        });

        Button btn_changeToSettings = (Button) findViewById(R.id.btn_settings);
        btn_changeToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Simulated cchange to settings", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }

    private void loadCharts(){
        LineChart chart = (LineChart) findViewById(R.id.chart);
        chart.setOnChartValueSelectedListener(this);

        chart.getXAxis().setLabelCount(11,  true);
        chart.getXAxis().setAxisMinimum(0);
        chart.getXAxis().setAxisMaximum(10);

        chart.getAxisLeft().setLabelCount(11,  true);
        chart.getAxisLeft().setAxisMinimum(0);
        chart.getAxisLeft().setAxisMaximum(10);

        chart.setScaleEnabled(false);
        chart.getAxisRight().setDrawLabels(false);
        chart.getAxisRight().setEnabled(false);
        chart.getDescription().setText("Tag");
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getXAxis().setValueFormatter(new DateXAxisConverter());
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
//try get data next activity - ui, etc

        /*try {
            Iterable<CalendarListEntry> events = CalendarDataAccess.Instance.Get();

            entries = new ArrayList<Entry>();

            for (CalendarListEntry data : events) {
                // turn your data into Entry objects
                //entries.add(new Entry(data.getValueX(), data.getValueY()));
                Toast toast = Toast.makeText(this, data.getDescription(), Toast.LENGTH_LONG);
                toast.show();
            }
        }
        catch (Exception ex) {
            Toast toast = Toast.makeText(this, "Could not load events." + ex.getMessage(), Toast.LENGTH_LONG);
            toast.show();
            Log.e("EGA",ex.getMessage());*/

                DateFormat format = new SimpleDateFormat("dd/MM", Locale.GERMAN);
                dataObjects = new ExampleClass[5];
                dataObjects[0] = new ExampleClass(1, 8, "Finish app");
                dataObjects[1] = new ExampleClass(4, 2, "My Birthday");
                dataObjects[2] = new ExampleClass(3, 1, "Meeting");
                dataObjects[3] = new ExampleClass(3, 5, "Second English Written Test");
                dataObjects[4] = new ExampleClass(6, 10, "Thesis Presentation");

            entries = new ArrayList<Entry>();
            for (ExampleClass data : dataObjects) {
                entries.add(new Entry(data.getValueX(), data.getValueY(), data));
            }
        //}


        LineDataSet dataSet = new LineDataSet(entries, ""); // add entries to dataset
        dataSet.setColor(10);
        dataSet.setFillColor(10);
        dataSet.setHighlightEnabled(true);
        dataSet.setCircleRadius(10);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        ExampleClass x = (ExampleClass)e.getData();

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.eventpopup, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(this.findViewById(android.R.id.content), Gravity.CENTER, 0, 0);

        ((TextView)popupView.findViewById(R.id.Information)).setText(x.getDescription());
        ((Button)popupView.findViewById(R.id.btnOK)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    @Override
    public void onNothingSelected() {
        
    }
}

