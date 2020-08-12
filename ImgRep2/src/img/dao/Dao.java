package img.dao;

import java.util.ArrayList;

import model.Img;

public interface Dao {
	void insert(Img img);
	ArrayList<Img> selectAll();
}
