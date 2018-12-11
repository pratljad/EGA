package db;

import java.util.List;

import domains.Event;

public class EventDAL implements IDAL<Event> {
	
	public static EventDAL Instance = new EventDAL();
	
	public EventDAL() {
		
	}


	@Override
	public List<Event> Get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	@Override
	public Event Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public Event Update(Event item) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Event Insert(Event item) {
		// TODO Auto-generated method stub
		return null;
	}

}
