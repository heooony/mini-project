package dto;

import java.util.ArrayList;
import java.util.List;

public class CSBoardDTO {

	private int boardNo; // 글번호 -> board_No
	private String subject; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private String boardDate; // 등록일 -> board_Data
	private int password;  // 비밀번호
	
	// 현재 글번호에 해당하는 답변(댓글) 정보
	private List<CSReplyDTO> replyList = new ArrayList<CSReplyDTO>();
	
	public CSBoardDTO() {}

	/**
	 * 내용 수정시 필요한 생성자
	 * */
	public CSBoardDTO(int boardNo, String content) {
		this.boardNo = boardNo;
		this.content = content;
	}

	public CSBoardDTO(int boardNo, String subject, String writer, String content, String boardDate, int password) {
		this(boardNo, content);
		this.subject = subject;
		this.writer = writer;
		this.boardDate = boardDate;
		this.password = password;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	
	
	public List<CSReplyDTO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<CSReplyDTO> replyList) {
		this.replyList = replyList;
	}
	
	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [");
		builder.append(boardNo);
		builder.append("] ");
		builder.append(writer);
		builder.append(" < ");
		builder.append(subject);
		builder.append(" > ");
		builder.append(boardDate);
		builder.append("\n");
		builder.append("\n      ");
		builder.append(content);
		builder.append("\n");
		return builder.toString();
	}
}
