package service;

import java.util.ArrayList;
import java.util.List;

import domain.Course;
import domain.Subject;
import domain.User;

import static utils.Util.*;



public class SubjectServiceImpl {

	private List<Subject> subjects = new ArrayList<Subject>(); // 과목등록
	private List<Course> courses = new ArrayList<Course>(); // 수강목록
	
	private UserService userService = UserService.getInstance();
	private static SubjectServiceImpl subjectService = new SubjectServiceImpl();

	private SubjectServiceImpl() {
	}

	public static SubjectServiceImpl getInstance() {
		return subjectService;
	}

	{
		subjects.add(new Subject(10001, 1, "경영학",  "id5"));
		subjects.add(new Subject(10002, 1, "인사관리","id6"));
		subjects.add(new Subject(10003, 2, "경제학",  "id7"));
		subjects.add(new Subject(10004, 1, "재무관리","id8"));

		courses.add(new Course(101, "id1", 10001));
		courses.add(new Course(102, "id2", 10003));
		courses.add(new Course(103, "id1", 10004));
		courses.add(new Course(104, "id2", 10002));
		courses.add(new Course(105, "id2", 10001));

	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	// 과목코드 , 학기, 과목이름, 담당교수id(참조변수)
	// 과목조회
	public void listSub() {
		System.out.print(convert("과목코드", 10));
		System.out.print(convert("학기", 7));
		System.out.print(convert("과목명", 12));
		System.out.println(convert("담당교수", 14));
		System.out.println("==============================================");
		
		for(Subject s : subjects) {
			System.out.print(convert(s.getCode(), 8));
			System.out.print(convert(s.getTerm(), 7));
			System.out.print(convert(s.getName(), 14));
			System.out.println(convert(UserService.getInstance().findBy(s.getProfId()).getName(), 13));
		}
	}

	// 과목 등록
	public void enrolSub() {
		int code = subjects.isEmpty() ? 10001 : subjects.get(subjects.size() - 1).getCode() + 1;
		int term = nextInt("학기 입력>");
		String name = nextLine("과목명 입력 >");
		String profId = userService.getUser().getId();
		System.out.println("과목등록이 완료되었습니다");
		System.out.println("===========================================");
		subjects.add(new Subject(code, term, name, profId));
	}

	// 과목 수정
	public void modifySub() {
		int i = nextInt("수정할 과목의 코드 >");
		Subject subject = findSubBy(i);
		if (subject == null) {
			System.out.println("존재하지 않는 과목코드입니다");
			return;
		} else if (subject.getProfId().equals(userService.getUser().getId())) {
			subject.setCode(nextInt(" 수정할 과목코드로 입력해주세요 > "));
		} else {
			System.out.println("해당 과목에 대한 권한이 없습니다.");
		}
	}

	// 과목 삭제
	public void removeSub() {
//		subjects.remove(findSubBy(nextInt("삭제할 과목의 코드 >")));
		int i = nextInt("삭제할 과목의 코드 >"); 
		Subject s = findSubBy(i); 
		if(s.getProfId().equals(userService.getUser().getId())) {
			System.out.println("해당과목의 삭제를 완료했습니다");
			subjects.remove(s);
			
		} else {
			System.out.println("해당과목을 삭제할 권한이 없습니다");
		}

	}
	
	public List<Course> getCourseList() {
		List<Course> list = new ArrayList<Course>();
		User user = UserService.getInstance().getUser();
		// 학생일때
		if(!user.isProf()) {
			for(Course c : courses) {
				if(c.getUserId().equals(user.getId())) { // 내가 수강신청한 목록의 조건
					list.add(c);
				}
			}
		}
		else {
			for(Course c : courses) {
				try {
					if(findSubBy(c.getSubId()).getProfId().equals(user.getId())) { // 내가 개설한 과목으로 수강신청한 수강 목록의 조건
						list.add(c);
					}
					
				} catch (NullPointerException e) {
					
				}
			}
		}
		// 교수일때
		return list;
	}

	public void listCourse(List<Course> list) {
		System.out.print(convert("과목명", 16));
		System.out.print(convert("수강코드", 10));
		System.out.print(convert("교수명", 10));
		System.out.println(convert("신청자", 10));
		System.out.println("====================================================");
		for(Course c : list) {
			try {
				System.out.print(convert(findSubBy(c.getSubId()).getName(), 16)); // NullPointerException
				System.out.print(convert(c.getCourseId(), 10));
				System.out.print(convert(userService.findBy(findSubBy(c.getSubId()).getProfId()).getName(), 10));
				System.out.println(convert(userService.findBy(c.getUserId()).getName(), 10));
			} catch (NullPointerException e) {
				
				}
		}
	}
	
	// 수강등록
	public void regCourse() {
		int subId = courses.isEmpty() ? 10001 : courses.get(courses.size() - 1).getCourseId() + 1; 

		courses.add(new Course(subId, UserService.getInstance().getUser().getId(), nextInt("수강 희망과목코드 입력 >")));
		System.out.println("수강신청이 완료되었습니다");
	}

	// 수강 변경
	public void modifyCourse() {
		Course course = findCourseBy(nextInt("변경할 수강코드 입력 >"));
		if (course == null) {
			System.out.println("존재하지 않는 수강코드입니다");
			return;
		} else if(!course.getUserId().equals(userService.getUser().getId())) {
			System.out.println("해당과목을 변경할 권한이 없습니다.");
		}
		listSub();
		int subCode = nextInt("변경할 과목 코드를 입력 > ");
		course.setSubId(subCode);
		System.out.println("변경이 완료되었습니다");
	}

	// 수강 취소
	public void removeCourse() {
		courses.remove(findCourseBy(nextInt("삭제할 수강코드 입력 >")));

	}

	public List<Course> getCourses() {
		return courses;
	}


	public Subject findSubBy(int code) {
		Subject subject = null;
		for (Subject b : subjects) {
			if (b.getCode() == code) {
				subject = b;
			}
		}
		return subject;
	}

	public Course findCourseBy(int courseId) {
		Course course = null;
		for (Course c : courses) {
			if (c.getCourseId() == courseId) {
				course = c;
			}
		}
		return course;
	}
	
//	d

}
