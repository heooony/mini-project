package dto;

/**
 * 답변 정보 관리 클래스
 * */
public class CSReplyDTO {

	private int replyNo;
	private String writer;
	private String content;
	private int boardNo;
	private String regDate;

	public CSReplyDTO() {}

	/**
	 * 댓글 수정시 필요한 생성자
	 * */
	public CSReplyDTO(int replyNo, String content) {
		this.replyNo = replyNo;
		this.content = content;
	}
	
	public CSReplyDTO(int replyNo, String writer, String content, int boardNo, String regDate) {
		this(replyNo, content);
		this.writer = writer;
		this.boardNo = boardNo;
		this.regDate = regDate;
	}
	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
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

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [");
		builder.append(replyNo);
		builder.append("] ");
		builder.append(writer);
		builder.append(" | ");
		builder.append(content);
		builder.append(" | ");
		builder.append(regDate);
		return builder.toString();
	}
	
}
