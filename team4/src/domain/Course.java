package domain;

import service.SubjectServiceImpl;
import service.UserService;

public class Course {
	private int courseId; // 수강코드Id

	private String userId; // 수강 학생Id
	private int subId; // 수강과목Id
	
	public Course() {
	}

	public Course(int courseId, String userId, int subId) {
		super();
		this.courseId = courseId;
		this.userId = userId;
		this.subId = subId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	@Override
	public String toString() {
		Subject s = SubjectServiceImpl.getInstance().findSubBy(subId);
		UserService service = UserService.getInstance();;
		return String.format("%10s%10s%10s%20s%10s", 
				courseId, service.findBy(userId).getName(), 
				s.getTerm(), s.getName(), 
				service.findBy(s.getProfId()).getName());
	}

	
	
}
