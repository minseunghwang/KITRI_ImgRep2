package img.service;

import java.util.ArrayList;

import img.dao.Dao;
import img.dao.DaoImpl;
import model.Img;


public class ServiceImpl implements Service{
	
	private Dao dao;
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addImg(Img img) {
		dao.insert(img);
	}

	@Override
	public ArrayList<Img> getAll() {
		return dao.selectAll();
	}

	@Override
	public int makeNum() {
		return dao.makeNum();
	}

	@Override
	public Img getImg(int num) {
		return dao.select(num);
	}

	@Override
	public int delImg(int num) {
		return dao.delete(num);
	}

	@Override
	public int editImg(Img i) {
		return dao.update(i);
	}
	
}
