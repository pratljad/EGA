package at.ega.appointmenthelper.DomainClasses;

import android.icu.text.SimpleDateFormat;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.Date;

public class MyXAxisValueFormatter implements IAxisValueFormatter {
    private String[] mValues;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    public MyXAxisValueFormatter(String[] values) {
        this.mValues = values; }


    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        // "value" represents the position of the label on the axis (x or y)
        return sdf.format(new Date((long) value));
    }
}
