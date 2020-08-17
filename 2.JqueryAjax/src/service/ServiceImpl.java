package service;

import java.util.ArrayList;

import dao.Dao;
import dao.DaoImpl;
import model.MemberVO;

public class ServiceImpl implements Service{
	
	private Dao dao;
	
	public ServiceImpl() {
		this.dao = new DaoImpl();
	}

	@Override
	public ArrayList idList() {
		return dao.idList();
	}

	@Override
	public MemberVO findMember(String id) {
		return dao.findMember(id);
	}

	@Override
	public void registerMember(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

}
