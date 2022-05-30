package service;


import java.util.ArrayList;
import java.util.List;

import domain.User;
import utils.Util;

public class UserService { //
	private User user; // 로그인 된 유저의 정보
	private List<User> users = new ArrayList<>(); // 모든 회원의 정보
	
	
	private static UserService service = new UserService();
	private UserService() {
		users.add(new User("id1", "1234", "김길동"));// 1
		users.add(new User("id2", "1234", "이길동"));// 2
		users.add(new User("id3", "1234", "박길동"));// 3
		users.add(new User("id4", "1234", "최길동"));// 4
		users.add(new User("id5", "1234", "김강찬", true));// 5	 // 교수님
		users.add(new User("id6", "1234", "이강찬", true));// 6  // 교수님
		users.add(new User("id7", "1234", "박강찬", true));// 7	 // 교수님
		users.add(new User("id8", "1234", "최강찬", true));// 8	 // 교수님
		
	}
	
	public static UserService getInstance() {
		return service;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getUsers() {
		return users;
	}

	
	public void register() {  // 회원 가입
		String id = Util.nextLine("등록할 아이디를 입력해주세요 : ");
		if(findBy(id) != null) {
			System.out.println("이미 가입된 회원의 id입니다");  // 리스트 내 중복된 아이디로 기재시 가입 불가
			return;
		}
		String pw = Util.nextLine("등록할 비밀번호를 입력해주세요 : ");
		String name = Util.nextLine("등록할 이름을 입력해주세요 : ");
		boolean prof = Util.nextLine("등록하시는 분의 소속이 교수일 경우 y를 입력해주세요 : ").equalsIgnoreCase("y");
		users.add(new User(id, pw, name, prof));
		System.out.println("등록에 성공하셨습니다");
	}
	public User findBy(String id) {
		for (int i = 0; i < users.size(); i++) {
			// 0 으로 초기화 후 i 가 users의size 범위 내에 있으면 i값을 증가
			User u = users.get(i);
			// users에 들어있는 값 중 i번째를 출력
			if (u != null && u.getId().equals(id))
				// User타입 u의 getId과 String타입의 id를 비교 후
				return u;
			// 일치시 u를 반환
		}
		return null;
		// 아니면 null 출력
	}
	public User findsBy(String id, String pw) {
		User u = findBy(id);
		if (u != null && u.getPassword().equals(pw)) {
			return u;
		}
		return null;
	}
	
	public void list() {  // 회원 정보 조회
		System.out.println(users);

	}
	public void login() {  // 로그인
		String id = Util.nextLine("아이디를 입력하세요");
		String pw = Util.nextLine("비밀번호 입력하세요");
		User u = findsBy(id, pw);
		if(u == null) {
			System.out.println("입력 정보가 올바르지 않습니다");
		}
		else {
			user = u; // 참조주소 대입
		}
	}
	
	// (로그인된)회원 정보 수정
	public void modify() {
		String pw = Util.nextLine("변경할 비밀번호를 입력해주세요 > ");
		String name = Util.nextLine("변경할 이름 입력해주세요 > ");
		
		user.setPassword(pw);
		user.setName(name);
		
	}

	public void remove() {
		users.remove(user);
		logout();
	}
	public void logout() {
		user = null;
	}
}