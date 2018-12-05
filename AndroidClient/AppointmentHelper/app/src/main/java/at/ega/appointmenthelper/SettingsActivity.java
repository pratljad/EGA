package at.ega.appointmenthelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btn_doBackup = (Button) findViewById(R.id.btn_statistics);
        btn_doBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simulated backup.", Toast.LENGTH_LONG).show();
                //attemptLogin();
            }
        });

        Button btn_backToMain = (Button) findViewById(R.id.btn_backToMain);
        btn_doBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simulated back to main.", Toast.LENGTH_LONG).show();
                //attemptLogin();
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            }
        });
    }
}
