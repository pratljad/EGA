package at.ega.appointmenthelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // Set up the login form.

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

    }
}
