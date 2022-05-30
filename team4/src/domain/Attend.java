package domain;

import java.util.Objects;
import java.util.StringJoiner;

// ★★시작날자와 끝나는날자(기간)★★ 를 캘린더로 땡겨온다.
// 1학기였을경우 주 5회
// 월,화,수,목,금
// 어떤 학생이 어떤수강에 어떻게 출석을 한다. 기본출석정보
// 1학기 : 3월달 20일간
// 2학기 : 9월달 20일간 
public class Attend {
	String studentId; // 학생정보
	int courseId; // 수강정보
	long time; // 시간(결석정보)

	public Attend() {
		// TODO Auto-generated constructor stub
	}

	public Attend(String studentId, int courseId, long time) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.time = time;
	}

// ★☆★☆★☆★현재 가이드라인★☆★☆★☆★☆★
	// 공백이 많고, 공백에 편집을해도
	// 틀어지지않는 달력출력
	// ★☆★☆★☆★현재 가이드라인★☆★☆★☆★☆★
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}


//	@Override // 추후 편집 필요...
//	public String toString() {
//		return new StringJoiner(", ", Attend.class.getSimpleName() + "[", "]").add("studentId='" + studentId + "'")// 학생ID
//				.add("coursID='" + courseId + "'") // 강의정보
////       .add("time=" + time)                    시간정보
//				.toString();
//	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//		Attend attend = (Attend) o;
//		return time == attend.time && Objects.equals(studentId, attend.studentId)
//				&& Objects.equals(coursID, attend.coursID);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(studentId, coursID, time);
//	}
}
