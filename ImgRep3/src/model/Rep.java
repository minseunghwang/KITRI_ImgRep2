package model;

public class Rep {
	private int num;
	private String writer;
	private String content;
	private int img_num;
	
	public Rep(){}
	public Rep(int num, String writer, String content, int img_num) {
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.img_num = img_num;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getImg_num() {
		return img_num;
	}
	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}
	@Override
	public String toString() {
		return "Rep [num=" + num + ", writer=" + writer + ", content="
				+ content + ", img_num=" + img_num + "]";
	}
	
	
}
