package at.ega.appointmenthelper;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateXAxisConverter implements IAxisValueFormatter {

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, Math.round(value));
            dt = c.getTime();

            return sdf.format(dt);
        } catch (Exception e) {
            return "No date";
        }

    }
}