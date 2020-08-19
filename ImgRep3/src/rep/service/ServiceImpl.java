package rep.service;

import java.util.ArrayList;

import model.Rep;
import rep.dao.Dao;
import rep.dao.DaoImpl;

public class ServiceImpl implements Service {
	private Dao dao;
	
	public ServiceImpl(){
		dao = new DaoImpl();
	}
	
	public void addRep(Rep rep) {
		dao.insert(rep);
	}

	public ArrayList<Rep> getRepsByImg_num(int img_num) {
		return dao.selectByImg_num(img_num);
	}

}
