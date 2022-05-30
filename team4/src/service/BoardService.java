package service;


// 해야할 기능 사전정의 
public interface BoardService {
	
	void list(); // 목록조회
	
	int totalpage (); // 전체페이지 계산
	
	void nextpage(); // 다음페이지로 이동
	
	void previouspage(); // 이전페이지로 이동
	
	void firstpage(); // 첫번째 페이지로 이동
	
	void lastpage(); // 마지막 페이지로 이동
	
	void movepage(); // 페이지번호 검색 후 해당 페이지로 이동
	
	void search(); // 검색어로 조회
	
	void detail(int i); // 글 세부내용
	
	void register(); // 글 등록
	
	void modify(int i);  // 글 수정
	
	void remove(int i); // 글 삭제
	
	void previousdetail(int i); // 이전글
	
	void nextdetail(int i); // 다음글
	
	void addcomment(int i); // 댓글 등록
	
	void deletecomment(int i); // 댓글 삭제
}
