package app;

import static utils.Util.nextLine;
import static utils.Util.nextInt;
import domain.User;
import service.AttendService;
import service.BoardServiceImpl;
import service.SubjectServiceImpl;
import service.UserService;
import utils.Util;

public class FinalEx {

	public static void main(String[] args) {
		UserService userService = UserService.getInstance();
		SubjectServiceImpl subjectService = SubjectServiceImpl.getInstance();
		AttendService attendService = AttendService.getInstance();
		BoardServiceImpl boardService = BoardServiceImpl.getInstance();
		
		// 중복 기본체크
		
		for (boolean a = true; a;) {
			User user = userService.getUser();
			if(user == null) { // 비 로그인 상태
				String Input = nextLine("1.회원가입 2.로그인");
				 switch (Input) {
				case "1":
					System.out.println("회원가입 페이지 입니다");
					userService.register();
					break;
				case "2":
					System.out.println("로그인 페이지 입니다");
					userService.login();
				}
			}
			else { // 로그인 상태
				if (user.isProf()) { // 교수 일때
					System.out.println(user.getName() + "교수님 환영합니다♡ Human university 입니다♡");
					System.out.println();
					
					c1: while (true) {
						int input = nextInt("1. 개설된 수강 목록 2. 수강과목 등록 3. 등록된 과목 수정 4. 등록된 과목 삭제 5. 내 정보 수정 6. 결석 등록 7. 출석 인정 8.로그아웃");
						switch (input) {
						case 1:
							subjectService.listSub();
							break;
						case 2:
							subjectService.enrolSub();
							break;
						case 3:
							subjectService.modifySub();
							break;
						case 4:
							subjectService.removeSub();
							break;
						case 5:
							userService.modify();
							break;
						case 6:
							subjectService.listCourse(subjectService.getCourseList());
							attendService.list(attendService.inputCourseId());
							attendService.register(attendService.inputCourseId());
							break;
						case 7:
							subjectService.listCourse(subjectService.getCourseList());
							attendService.list(attendService.inputCourseId());
							attendService.remove(attendService.inputCourseId());
							break;
						case 8:
							userService.logout();
							break c1;
						}
					}
				}

				else { // 학생일 때
					System.out.println(user.getName() + "님 환영합니다♡ Human university 입니다♡");
					System.out.println();
					c3 : while (true) {
						int input = nextInt("1. 수강 관리  2. 게시판  3. 마이페이지   4. 로그아웃");
						switch (input) {
						case 1:
							c2: while (true) {
								input = nextInt("1. 수강 신청 2. 수강 변경 3. 수강 취소 4. 나의 수강 내역 조회 0. 로그인 메뉴 ");
								switch (input) {
								case 1:
									subjectService.listSub(); // 수강 가능 목록 listSub()에서 내가 이미 신청한 과목은 볼 수 없는 조건 추가
									subjectService.regCourse(); // 수강과목신청시 과목코드 입력하여 학기, 과목명, 학생이름 추가되도록 참조
									break;
								case 2:
									subjectService.listCourse(subjectService.getCourseList());
									subjectService.modifyCourse(); // 수강과목 변경
									break;
								case 3:
									subjectService.listCourse(subjectService.getCourseList());
									subjectService.removeCourse(); // 수강과목 삭제
									break;
								case 4:
									subjectService.listCourse(subjectService.getCourseList());
									break;
								case 0:
									break c2;
								}
							}
							break;
						case 2: 
							while (true){
								boardService.list();
								System.out.println("search-s 검색  write-w 새글  next-n 다음페이지  previous-p 이전페이지  back- b 뒤로가기");
								System.out.print(
										"=========================================================================================================");
								String Input = nextLine("");
								switch (Input) {
								case "s":
									boardService.search();
									break;
	
								case "w":
									boardService.register();
									break;
	
								case "n":
									boardService.nextpage();
									break;
									
								case "p":
									boardService.previouspage();
									break;
									
								case "f":
									System.out.println("첫번째 페이지로 이동합니다");
									boardService.firstpage();
									break;
									
								case "l":
									System.out.println("마지막 페이지로 이동합니다");
									boardService.lastpage();
									break;
									
								case "m":
									boardService.movepage();
									break;
									
								case "b":
									System.out.println("뒤로가기");
									break c3;
								default:
									try {
										int i = Integer.parseInt(Input);
										boardService.detail(i);
										
									} catch (NumberFormatException e) {
										System.out.println("잘못된 명령어입니다.");
									}
									break;
								}
							}
						case 3:
							c2: while (true) {
								input = nextInt("1. 내 출결 조회  2. 정보 수정  3. 탈퇴 0. 이전 메뉴");
								switch (input) {
								case 1:
									subjectService.listCourse(subjectService.getCourseList());
									attendService.list(attendService.inputCourseId()); 
									break;
								case 2:
									userService.modify(); 
									break;
								case 3:
									userService.remove(); 
									break c3;
								case 0:
									break c2;
								}
							}
							break;
						case 4:
							userService.logout();
						case 0:
							break c3;
						}
						
					}
				}
			}
		}
	}
}	
