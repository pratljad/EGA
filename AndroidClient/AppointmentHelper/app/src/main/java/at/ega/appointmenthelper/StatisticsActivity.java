package at.ega.appointmenthelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Button btn_doBackup = (Button) findViewById(R.id.btn_backToCalendar);
        btn_doBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simulated back to Calendar.", Toast.LENGTH_LONG).show();
                //attemptLogin();
                startActivity(new Intent(StatisticsActivity.this, MainActivity.class));
            }
        });
    }
}
