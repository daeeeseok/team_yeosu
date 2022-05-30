package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static utils.Util.*;

import domain.Board;
public class BoardServiceImpl implements BoardService {

	UserService userService = UserService.getInstance();
	
	private static BoardServiceImpl boardService = new BoardServiceImpl();
	
	private BoardServiceImpl() {}

	public static BoardServiceImpl getInstance() {
		return boardService;
	}

	private List<Board> boards = new ArrayList<Board>(); // 게시글 
	
	
	

//		총 게시글 수  boards.size()
//		한 화면에 나올 게시글 수  5
//		총 페이지 수  (boards.size() % 5 > 0)일경우 : (boards.size() / 5)+ 1
//					  (boards.size() % 5 == 0)일경우 :  boards.size() / 5				
//		현재 페이지 

	int currentpage = 1;

	public void list() { // 게시글 목록
		int j = (currentpage - 1) * 5;
			System.out.println(
				"=========================================================================================================");
			System.out.println(String.format("%s", convert("Human university게시판", 60)));
			System.out.println(
					"=========================================================================================================");
			System.out.println(String.format("%s%s%s%s%s%s", 
					convert("번호", 3),
					convert("제목", 20),
					convert("이름", 20),
					convert("작성일", 20),
					convert("조회수", 20),
					convert("댓글수", 20)));
			System.out.println(
					"=========================================================================================================");
			try {
				for (int i = j; i < j + 5; i++) {
					System.out.println(String.format("%-3d%s%s%s%20d%20d",
							boards.get(i).getNum(),
							convert(boards.get(i).getTitle(), 20),
							convert(boards.get(i).getName(), 20),
							convert(new SimpleDateFormat("yy-MM-dd").format(boards.get(i).getTime()), 20),
							boards.get(i).getView(),
							boards.get(i).getComments().size()));
				}
			} 
			catch (IndexOutOfBoundsException e) {
			}
			System.out.println(
					"=========================================================================================================");
			System.out.println(String.format("%s%s%s%s%s",
					convert("현재 페이지 - " + currentpage, 15),
					convert("총페이지 - " + totalpage(), 15),
					convert("first - f 첫번째페이지", 25),
					convert("last - l 마지막페이지", 25),
					convert("move - m 페이지번호검색", 25)
					));
			System.out.println(
					"=========================================================================================================");
	}
	
	public void search() { // 게시글 검색
		List<Board> words = new ArrayList<>(); // 검색어를 포함한 게시글 목록
		String str = nextLine("검색어를 입력해주세요");
		Board word = findBy(str);

		if (boards.contains((word))) {
			for (Board w : boards) {
				words.add(w);
			}
			System.out.println(str + "로 검색한 결과");
			System.out.println(
					"=========================================================================================================");
			System.out.println(String.format("%s%s%s%s%s%s",
					convert("번호", 3),
					convert("제목", 20),
					convert("이름", 20),
					convert("작성일", 20),
					convert("조회수", 20),
					convert("댓글수", 20)));
			System.out.println(
					"=========================================================================================================");
			for (Board b : words) {
				System.out.println(String.format("%-3d%s%s%s%20d%20d", b.getNum(), convert(b.getTitle(), 20),
						convert(b.getName(), 20),
						convert(new SimpleDateFormat("yy-MM-dd").format(b.getTime()) + "", 20),
						b.getView(),
						b.getComments().size()
						));
			}
			System.out.println(
					"=========================================================================================================");
			try {
				int i = nextInt("글 번호를 입력해 주세요");
				detail(i);
				
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요!!");
			}

		} else {
			System.out.println("존재하지 않는 게시물입니다.");
			System.out.println("목록으로 돌아갑니다.");
		}
	}

	public void detail(int i) { // 게시글 상세조회
		System.out.println(i+"번글로 이동합니다");
		Board b = findBy(i);
		if (b == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			System.out.println("목록으로 돌아갑니다.");
		} else {
			int v = b.getView();
			b.setView(++v);
			System.out.println(String.format("%s%s%s%s%s%s",
					convert("번호", 5),
					convert("제목", 20),
					convert("이름", 20),
					convert("Id", 20),
					convert("조회수", 10),
					convert("작성시간", 30)
					));
			System.out.println(
					"=========================================================================================================");
			System.out.println(String.format("%-5d%s%s%s%10d%s",
					b.getNum(),
					convert(b.getTitle(), 20),
					convert(b.getName(), 20),
					convert(b.getId(), 20),
					b.getView(),
					convert(new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(b.getTime()), 30)
					));
			System.out.println(
					"=========================================================================================================");
			System.out.println(b.getBody());
			System.out.println();
			System.out.println(
					"=========================================================================================================");
			if (b.getComments().size() == 0) {
				System.out.println("현재 댓글이 없습니다. 댓글을 등록해보세요");
			} else {
				for (Board c : b.getComments()) {
					System.out.println(String.format("%s%s%s",
							convert(c.getName(), -8),
							convert(c.getComment(), -20),
							convert(new SimpleDateFormat("MM-dd HH:mm:ss").format(c.getTime()), 20)));
				}
			}
			System.out.println(
					"=========================================================================================================");
			System.out.println("add-a 댓글등록  delete-d 댓글 삭제");
			System.out.println(
					"=========================================================================================================");
			System.out.println("previous-p 이전글 next-n 다음글 modify-m 수정 remove-r 삭제 write-w 새글 list-l 목록");
			System.out.println(
					"=========================================================================================================");
			String Input = nextLine("");
							
			switch (Input) {
			
			case "p":
				previousdetail(i);
				break;

			case "n":
				nextdetail(i);
				break;

			case "m":
				modify(i);
				break;

			case "r":
				remove(i);
				break;

			case "w":
				register();
				break;

			case "a":
				addcomment(i);
				break;

			case "d":
				deletecomment(i);
				break;

			case "l":
				break;

			default:
				System.out.println("잘못된 명령어입니다.");
				break;
			}
		}
	}

	public void previousdetail(int i) { // 이전글
		i -= 1;
		detail(i);
	}

	public void nextdetail(int i) { // 다음글
		i += 1;
		detail(i);
	}

	public void register() { // 게시글 등록
		int i;
		if (boards.size() == 0) {
			i = 1;
		} else {
			i = boards.get(0).getNum();
			i += 1;
		}
		String str = nextLine("제목(최대10글자!!)");
		if(str.length() > 10) {
			str = str.substring(0, 10);
		}
		boards.add(0, new Board(i, str,
				userService.getUser().getName(),
				userService.getUser().getId(),
				System.currentTimeMillis(),
				0,
				nextLine("내용")));
	}

	public void modify(int i) { // 게시글 수정
		Board boards = findBy(i);
		boards.setTitle(nextLine("제목"));
		boards.setBody(nextLine("내용"));
		boards.setTime(System.currentTimeMillis());
	}

	public void remove(int i) { // 게시글 삭제
		Board b = findBy(i);
		int v = boards.get(i).getView();
		if (b.getId().equals(userService.getUser().getId())
				&& b.getName().equals(userService.getUser().getName()) == true) {
			String str = nextLine("해당 글을 삭제 하시겠습니다까? y/n");
			switch (str) {
				case "y":
					boards.remove(findBy(i));
					System.out.println("해당글은 삭제되었습니다.");
					break;
				case "n":
					System.out.println("해당 게시물로 돌아갑니다.");
					boards.get(i).setView(--v);
					detail(i);
					break;
				default:
					System.out.println("잘못된 명령어 입니다.");
					boards.get(i).setView(--v);
					detail(i);
					break;
			}
		} else {
			System.out.println("해당 글을 삭제할 권한이 없습니다.");
			boards.get(i).setView(--v);
			detail(i);
		}
	}

	public void addcomment(int i) {
		Board details = findBy(i);
		details.getComments()
				.add(new Board(userService.getUser().getName(),
						nextLine("댓글내용"),
						System.currentTimeMillis()));
	}

	public void deletecomment(int i) { //댓글 삭제 >> 삭제할 댓글의 순번 선택 후 >> 이름, id 일치 시 삭제 가능
		Board details = findBy(i);
		int v = boards.get(i).getView();
		int r = nextInt("삭제할 댓글의 순번") - 1;
		if (details.getComments().get(r).getName().equals(userService.getUser().getName())
				&& details.getComments().get(r).getId().equals(userService.getUser().getId())
						== true) {
			details.getComments().remove(r);
			boards.get(i).setView(--v);
			detail(i);
		} else {
			System.out.println("해당 댓글을 삭제할 권한이 없습니다!!");
			boards.get(i).setView(--v);
			detail(i);
		}
	}
	
	public int totalpage () { //전체 페이지수 구하는 메서드 게시글이 0개인경우 1로 반환
		if(boards.size() == 0) {
			return 1;
		} else {
			return (boards.size() / 5) + (boards.size() % 5 > 0 ? 1 : 0);
		}
	}

	public void nextpage() { // 현재페이지 +1 후 다음페이지 이동 >> 다음페이지 부존재시 현재페이지 -1 
		currentpage += 1;
		if(currentpage > totalpage()) {
			System.out.println("해당하는 페이지가 없습니다!!");
			currentpage -= 1;
		}
	}

	public void previouspage() { // 이전페이지 -1 후 이전페이지 이동 >> 이전페이지가 1보다 작을 경우 현재페이지 +1
		currentpage -= 1;
		if (currentpage < 1) {
			System.out.println("해당하는 페이지가 없습니다!!");
			currentpage += 1;
		}
	}
	
	public void firstpage() { // 제일 첫번째 페이지인 1페이지로 이동
		currentpage = 1;
	}
	
	public void lastpage() { // 마지막 페이지로 이동
		currentpage = totalpage();
	}
	
	public void movepage() {
		try {
			int i = nextInt("이동하실 페이지번호를 입력해주세요");
			if(i < 1 || i > totalpage()) {
				System.out.println("해당하는 페이지가 없습니다!!");
			} else {
				currentpage = i;
				System.out.println(i+"번째 페이지로 이동합니다");
			}
			
		} catch (NumberFormatException e) {
			System.out.println("잘못된 명령어입니다.");
		}
		
	}
	
	private Board findBy(int i) {
		for (Board b : boards) {
			if (b.getNum() == i) {
				return b;
			}
		}
		return null;
	}

	private Board findBy(String str) {
		for (Board b : boards) {
			if (b.toString().contains(str)) {
				return b;
			}
		}
		return null;
	}
}
