package domain;

public class User {//

	private String id; // user 아이디
	private String password; // user 비밀번호
	private String name; // user 이름

	private boolean prof;    // false일때는 학생 , true일때는 교수님
	
	public User() {

	}

	public User(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public User(String id, String password, String name, boolean prof) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.prof = prof;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isProf() {
		return prof;
	}

	public void setProf(boolean prof) {
		this.prof = prof;
	}
}