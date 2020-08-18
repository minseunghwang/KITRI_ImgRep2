package model;

import java.sql.Date;
import java.util.ArrayList;

public class Img {
	private int num;
	private String writer;
	private String pwd;
	private String title;
	private String path;
	private Date u_date;
	private ArrayList<Rep> reps;
	
	public Img() {}

	public Img(int num, String writer, String pwd, String title, String path, Date u_date) {
		super();
		this.num = num;
		this.writer = writer;
		this.pwd = pwd;
		this.title = title;
		this.path = path;
		this.u_date = u_date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "Img [num=" + num + ", writer=" + writer + ", pwd=" + pwd + ", title=" + title + ", path=" + path
				+ ", u_date=" + u_date + "]";
	}
}
