package order.service;

import java.util.ArrayList;

import model.Order;
import order.dao.Dao;
import order.dao.DaoImpl;

public class ServiceImpl implements Service {
	private Dao dao;
	public ServiceImpl() {
		dao = new DaoImpl();
	}
	@Override
	public void addOrder(Order o) {
		dao.insert(o);
	}

	@Override
	public Order getOrder(int num) {
		return dao.select(num);
	}

	@Override
	public ArrayList<Order> orderList(String o_id, int o_state) {
		return dao.selectAll(o_id, o_state);
	}

	@Override
	public void editState(String type, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delOrder(int num) {
		// TODO Auto-generated method stub
		
	}

}
