package domain;

import service.SubjectServiceImpl;
import service.UserService;

// 과목 수강 같이 다룸
public class Subject {
	private int code; // 과목코드
	private int term; // 학기
	private String name; // 과목이름
	private String profId; // 담당교수 < personal id

	public Subject() {
	}

	public Subject(int code, int term, String name, String profId) {
		super();
		this.code = code;
		this.term = term;
		this.name = name;
		this.profId = profId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfId() {
		return profId;
	}

	public void setProfId(String profId) {
		this.profId = profId;
	}

	@Override
	public String toString() {
		return String.format("Subject [code=%s, term=%s, name=%s, profId=%s]", code, term, name, UserService.getInstance().findBy(profId).getName());
	}
	

}