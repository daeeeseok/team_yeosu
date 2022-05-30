package domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Board {
	private int num;       // 글 번호 pk(고유값을 1번으로) 
	private String title;  // 글 제목
	private String body;   // 글 내용
	private long time;     // 작성시간
	private int view;      // 글 조회수
	private String comment; // 댓글
	private List<Board> comments = new ArrayList<Board>();  // 댓글리스트
	
	private String id;     // 작성자 id (personal 참조값은 맨아래로)
	private String name;   // 작성자 이름

	public Board() {
	}
	public Board(int num, String title, String name, String id, long time, int view, String body, List<Board> comments, String comment) {
		this.num = num;
		this.title = title;
		this.name = name;
		this.id = id;
		this.time = time;
		this.view = view;
		this.body = body;
		this.comments = comments;
		this.comment = comment;
	}
	public Board(int num, String title, String name, String id, long time, int view, String body) {
		this.num = num;
		this.title = title;
		this.name = name;
		this.id = id;
		this.time = time;
		this.view = view;
		this.body = body;
	}
	

	public Board(String name, String comment, long time) {
		this.name = name;
		this.time = time;
		this.comment = comment;
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
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	public int getView() {
		return view;
	}
	
	public void setView(int view) {
		this.view = view;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public List<Board> getComments() {
		return comments;
	}
	
	public void setComments(List<Board> comments) {
		this.comments = comments;
	}
	
	public String toString() {
		return num  + title + name + id + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(getTime()) + view + body + comment;
	}
}

