package db;

import java.util.List;

import domains.EGAUser;

public class EGAUserDAL implements IDAL<EGAUser> {

	public static EGAUserDAL Instance = new EGAUserDAL();
	
	public EGAUserDAL() {
		
	}
	
	
	@Override
	public List<EGAUser> Get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EGAUser Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EGAUser Update(EGAUser item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EGAUser Insert(EGAUser item) {
		// TODO Auto-generated method stub
		return null;
	}


}
