package service;

import static utils.Util.convert;
import static utils.Util.epoch2Str;
import static utils.Util.nextInt;
import static utils.Util.nextLine;
import static utils.Util.str2Epoch;

import java.util.ArrayList;
import java.util.List;

import domain.Attend;
import domain.Subject;

public class AttendService {
	private List<Attend> attends = new ArrayList<Attend>();
	
	private static AttendService attendService = new AttendService();
	private UserService userService = UserService.getInstance();
	private SubjectServiceImpl subjectServiceImpl = SubjectServiceImpl.getInstance();
	private AttendService() {
		attends.add(new Attend("id1", 101, str2Epoch("2022-03-03")));
		attends.add(new Attend("id2", 101, str2Epoch("2022-03-03")));
		attends.add(new Attend("id1", 103, str2Epoch("2022-03-03")));
		attends.add(new Attend("id1", 101, str2Epoch("2022-03-04")));
		attends.add(new Attend("id1", 101, str2Epoch("2022-03-07")));
	}

	public static AttendService getInstance() {
		return attendService;
	}
	
	// 결석 등록
	public void register(int courseId) {
		String userId = subjectServiceImpl.findCourseBy(courseId).getUserId();
		String date = nextLine("결석으로 등록할 날짜를 입력(ex:2022-02-02)");
		
		attends.add(new Attend(userId, courseId, str2Epoch(date)));
	}
	
	// 달력 출력
	public void list(int courseId) {
		System.out.print(convert("결석 과목명", 16));
		System.out.print(convert("결석자 이름", 12));
		System.out.println(convert("결석 일자", 16));
		System.out.println("=============================================");
		for(Attend a : attends) {
			try {
				Subject subject = subjectServiceImpl.findSubBy(subjectServiceImpl.findCourseBy(courseId).getSubId());
				if( courseId == a.getCourseId() && 
						userService.findBy(a.getStudentId()).getId().equals(subjectServiceImpl.findCourseBy(courseId).getUserId())) {
					System.out.print(convert(subject.getName(), 16)); // NullPointerException
					System.out.print(convert(userService.findBy(a.getStudentId()).getName(), 12));
					System.out.println(convert(epoch2Str(a.getTime()), 16));
				}
			} catch (NullPointerException e) {
//				break;
			}
		}
	}
	
	public int inputCourseId() {
		return nextInt("수강코드를 입력 > ");
	}
	
	// 결석 > 출석
	public void remove(int courseId) {
		long date = str2Epoch(nextLine("출석으로 변경할 날짜를 입력(ex:2022-02-02)"));
		
		attends.remove(findBy(courseId, date));
	}
	
	public Attend findBy(int courseId, long date) {
		for(Attend a : attends) {
			if(a.getCourseId() == courseId && a.getTime() == date) {
				return a;
			}
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		AttendService as = new AttendService();
//		as.userService.setUser(as.userService.findBy("id1"));
//		as.list(as.inputCourseId());
//		as.register(as.inputCourseId());
//		as.list(as.inputCourseId());
//		as.remove(as.inputCourseId());
//		as.list(as.inputCourseId());
//	}
	// 전채적으로 강민씨의 id(학생의정보)  +
	// 윤정누님의 course(강의의정보) 
	// 정보로 대대적인 수정이 있어야한다.
	
	// CRUD, Create, Read, Update, Delete

	// Create //studentId 는 학생의 id값으로 교채되어야한다.
//	public void createAttendance(String studentId, String courseId) {
//		Attend newAttend = new Attend();
//		newAttend.setStudentId(studentId);
//		newAttend.setCoursID(courseId);
//		newAttend.setTime(System.currentTimeMillis());
//		newAttend.setAttended(false);
//
//		attends.add(newAttend);
//	}
//// ===========================조회파트=====================================
//	// Read 01
//	// 학생의 id 로만 조회할경우  	// 실험 성공적
//	public List<Attend> findByStudentId(String studentId) {
//		List<Attend> found = new ArrayList<>();
//
//		for (Attend attend : attends) {
//			if (attend.getStudentId().equals(studentId)) {
//				found.add(attend);
//			}
//		}
//
//		return found;
//	}
//	
//	// Read 02
//	// 분기로만 조회할경우     	    // 실험 성공적
//	public List<Attend> findByCourseId(String courseId) {
//		List<Attend> found = new ArrayList<>();
//		
//		for (Attend attend : attends) {
//			if (attend.getCoursID().equals(courseId)) {
//				found.add(attend);
//			}
//		}
//		
//		return found;
//	}
//	
//
//	// Read 03                  	
//	// 학생의 id와 course정보로 조회할경우   // 실험 성공적
//	public Attend findByStudentIdAndCourseId(String studentId, String courseId) {
//		for (Attend attend : attends) {
//			if (attend.getStudentId().equals(studentId) && attend.getCoursID().equals(courseId)) {
//				return attend;
//			}
//		}
//
//		return null;
//	}
//	// Read 04               	 
//	// 시간으로 조회할경우  	   // 실험 실패?
//	public List<Attend> findByTime(long time) {
//		List<Attend> found = new ArrayList<>();
//		
//		for (Attend attend : attends) {
//			if (attend.getTime() == time) {
//				found.add(attend);
//			}
//		}
//		
//		return found;
//	}
//// ===========================조회파트 끝=====================================
//
//	
//	// Update 출석정보 업데이트 (출석)
//	public void updateAttendance(String studentId, String courseId) {
//		Attend target = findByStudentIdAndCourseId(studentId, courseId);
//
//		List<Attend> newAttends = new ArrayList<>();
//
//		for (Attend attend : attends) {
//			if (attend.equals(target)) {
//				attend.setAttended(true); // 해당 학생이 해당 과목에 출석을한다.
//			}
//
//			newAttends.add(attend);
//		}
//
//		attends = newAttends;
//	}
//
//	// Delete 정보 삭제
//	public void deleteAttend(String studentId, String courseId) {
//		Attend target = findByStudentIdAndCourseId(studentId, courseId);
//
//		if (target == null) {
//			return;
//		}
//
//		attends.remove(target);
//	}
//
//	public void list() {
//		for (Attend attend : attends) {
//			System.out.println(attend);
//		}
//	}

//  기능 동작 테스트.
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//
//		AttendService attendService = new AttendService();
//		attendService.list();
//		System.out.println();
//
//		while (true) {
//			System.out.print("원하는 동작을 선택하세요 (CRUD): ");
//			final String crud = scanner.nextLine();
//
//			switch (crud) {
//			case "C":
//				System.out.print("학생 ID: ");
//				String createStudentId01 = scanner.nextLine();
//				System.out.print("강의 ID: ");
//				String createCourse01Input = scanner.nextLine();
//				attendService.createAttendance(createStudentId01, createCourse01Input);
//				break;
//			case "R":
//				System.out.println("학생 ID 로 검색");
//				System.out.print("학생 ID: ");
//				final String studentId = scanner.nextLine();
//				final List<Attend> byStudentId = attendService.findByStudentId(studentId);
//				System.out.println("found: ...");
//				System.out.println(byStudentId);
//				System.out.println();
//				break;
//			case "U":
//				System.out.print("학생 ID: ");
//				String updateStudentId01 = scanner.nextLine();
//				System.out.print("강의 ID: ");
//				String updateCourse01Input = scanner.nextLine();
//				attendService.updateAttendance(updateStudentId01, updateCourse01Input);
//				break;
//			case "D":
//				System.out.print("학생 ID: ");
//				String deleteStudentId01 = scanner.nextLine();
//				System.out.print("강의 ID: ");
//				String deleteCourse01Input = scanner.nextLine();
//				attendService.deleteAttend(deleteStudentId01, deleteCourse01Input);
//				break;
//			default:
//				System.out.println("CRUD 중에 입력을 해주세요.");
//			}
//
//			System.out.println("-------------------");
//			attendService.list();
//		}

//  read test
//    System.out.println("02");
//    List<Attend> student01 = attendService.findByStudentId("student01");
//    System.out.println(student01);

//    List<Attend> course01 = attendService.findByCourseId("course01");
//    System.out.println(course01);
//    Attend s03c03 = attendService.findByStudentIdAndCourseId("student03", "course03");
//    System.out.println(s03c03);

//    update test
//    System.out.println("03");
//    attendService.updateAttendance("student03", "course01");
//    attendService.list();

//    delete test
//    System.out.println("04");
//    attendService.deleteAttend("user01", "course01");
//    attendService.list();

}
