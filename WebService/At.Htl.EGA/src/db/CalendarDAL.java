package db;

import java.util.List;

import domains.Calendar;

public class CalendarDAL  implements IDAL<Calendar>{

	public static CalendarDAL Instance = new CalendarDAL();
	
	public CalendarDAL() {
		
	}
	
	@Override
	public List<Calendar> Get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calendar Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Calendar Update(Calendar item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calendar Insert(Calendar item) {
		// TODO Auto-generated method stub
		return null;
	}

}
