package model;

import java.sql.Date;
import java.util.ArrayList;

public class Img {
	private int num;
	private String title;
	private String writer; 
	private String path;
	private Date u_date;
	private ArrayList<Rep> reps;
	
	public Img(){}

public Img(int num, String title, String writer, String path, Date u_date, ArrayList<Rep> reps) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.path = path;
		this.u_date = u_date;
		this.reps = reps;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getU_date() {
		return u_date;
	}

	public void setU_date(Date u_date) {
		this.u_date = u_date;
	}

	public ArrayList<Rep> getReps() {
		return reps;
	}

	public void setReps(ArrayList<Rep> reps) {
		this.reps = reps;
	}

	@Override
	public String toString() {
		return "Img [num=" + num + ", title=" + title + ", writer=" + writer + ", path=" + path + ", u_date=" + u_date
				+ ", reps=" + reps + "]";
	}

	
	
}
