package at.ega.appointmenthelper.DomainClasses;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ChartFormatter implements IValueFormatter {
    private int nrOfCurrImportance;
    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return ((int) value)+"()";
    }
}
