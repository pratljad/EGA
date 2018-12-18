package at.ega.appointmenthelper.DataAccess;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;

import java.io.IOException;
import java.util.List;

import at.ega.appointmenthelper.Interfaces.IDataAccess;

public class CalendarDataAccess implements IDataAccess<CalendarListEntry> {

    public static CalendarDataAccess Instance = new CalendarDataAccess();

    private CalendarDataAccess() { }

    public Iterable<CalendarListEntry> Get() throws IOException {
        Calendar cService = CalendarService.Instance.GetService();
        List<CalendarListEntry> items;

        // Iterate through entries in calendar list
        String pageToken = null;
        do {
            CalendarList calendarList = cService.calendarList().list().setPageToken(pageToken).execute();
            items = calendarList.getItems();

            for (CalendarListEntry calendarListEntry : items) {
                System.out.println(calendarListEntry.getSummary());
            }
            pageToken = calendarList.getNextPageToken();
        } while (pageToken != null);

        return items;
    }

    public CalendarListEntry Get(int id) throws IOException {
        Calendar cService = CalendarService.Instance.GetService();
        CalendarListEntry calendarListEntry = cService.calendarList().get(Integer.toString(id)).execute();
        return calendarListEntry;
    }

    public void Delete(int id) {
        return;
    }

    public CalendarListEntry Insert(CalendarListEntry o) {
        return null;
    }

    public CalendarListEntry Update(CalendarListEntry o) {
        return null;
    }
}
