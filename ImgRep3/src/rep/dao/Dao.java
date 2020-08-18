package rep.dao;

import java.util.ArrayList;

import model.Rep;

public interface Dao {
	void insert(Rep rep);
	ArrayList<Rep> selectByImg_num(int img_num);
}
