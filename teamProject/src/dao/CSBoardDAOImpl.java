package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.CSBoardDTO;
import dto.CSReplyDTO;
import dto.Customer;
import dto.Price;

public class CSBoardDAOImpl implements CSBoardDAO {
	
	private Properties proFile = DBUtil.getProfile();
	
	/**
	 * ID로 회원 검색
	 * */
	@Override
	public Customer searchUserByID(String id) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer customer = null;
		String sql = proFile.getProperty("user.searchByID");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getString(9), rs.getString(10));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}		
		return customer;
	}

	/**
	 * 전체 게시글 출력
	 * */
	@Override
	public List<CSBoardDTO> boardSelectAll() throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<CSBoardDTO> list = new ArrayList<CSBoardDTO>();
		String sql = proFile.getProperty("board.selectAll");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int boardNo = rs.getInt("board_no");
				String subject = rs.getString("subject");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String boardDate = rs.getString("board_date");
				
				CSBoardDTO dto = new CSBoardDTO(boardNo, subject, writer, content, boardDate);
				List<CSReplyDTO> replyList = this.replyList(con, boardNo);
				dto.setReplyList(replyList);
				
				list.add(dto);
			}
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	/**
	 * 번호에 해당하는 게시글 검색
	 * */
	@Override
	public CSBoardDTO boardSelectByNo(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CSBoardDTO boardDTO = null;
		String sql = proFile.getProperty("board.selectByNo");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				boardDTO = new CSBoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			
				List<CSReplyDTO> replyList = this.replyList(con, boardNo);
				boardDTO.setReplyList(replyList);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}		
		return boardDTO;
	}
	
	/**
	 * 제목 검색
	 * */
	@Override
	public List<CSBoardDTO> boardSelectBySubject(String keyWord) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CSBoardDTO> list = new ArrayList<CSBoardDTO>();
		String sql = proFile.getProperty("board.selectBySubject");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int boardNo = rs.getInt("board_no");
				String subject = rs.getString("subject");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String boardDate = rs.getString("board_date");
				
				CSBoardDTO dto = new CSBoardDTO(boardNo, subject, writer, content, boardDate);
				List<CSReplyDTO> replyList = this.replyList(con, boardNo);
				dto.setReplyList(replyList);
			
				list.add(dto);
			}
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	/**
	 * 작성자 검색
	 * */
	@Override
	public List<CSBoardDTO> boardSelectByWriter(String keyWord) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CSBoardDTO> list = new ArrayList<CSBoardDTO>();
		String sql = proFile.getProperty("board.selectByWriter");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int boardNo = rs.getInt("board_no");
				String subject = rs.getString("subject");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String boardDate = rs.getString("board_date");
				
				CSBoardDTO dto = new CSBoardDTO(boardNo, subject, writer, content, boardDate);
				List<CSReplyDTO> replyList = this.replyList(con, boardNo);
				dto.setReplyList(replyList);
			
				list.add(dto);
			}
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	/**
	 * 내용 검색
	 * */
	@Override
	public List<CSBoardDTO> boardSelectByContent(String keyWord) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CSBoardDTO> list = new ArrayList<CSBoardDTO>();
		String sql = proFile.getProperty("board.selectByContent");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int boardNo = rs.getInt("board_no");
				String subject = rs.getString("subject");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String boardDate = rs.getString("board_date");
				
				CSBoardDTO dto = new CSBoardDTO(boardNo, subject, writer, content, boardDate);
				List<CSReplyDTO> replyList = this.replyList(con, boardNo);
				dto.setReplyList(replyList);
			
				list.add(dto);
			}
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	/**
	 * 게시글 입력
	 * */
	@Override
	public int boardInsert(CSBoardDTO boardDTO) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("board.insert");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, boardDTO.getSubject());
            ps.setString(2, boardDTO.getWriter());
            ps.setString(3, boardDTO.getContent());
            
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 게시글 수정
	 * */
	@Override
	public int boardUpdate(CSBoardDTO boardDTO) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("board.updateByNo");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, boardDTO.getContent());
            ps.setInt(2, boardDTO.getBoardNo());
            
            result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 글번호에 해당하는 게시글 삭제
	 * */
	@Override
	public int boardDelete(int boardNo) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("board.deleteByNo");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);
            
			replyDeleteByBoardNo(boardNo);
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 부모글번호에 해당하는 댓글 삭제하기
	 * */
	public int replyDeleteByBoardNo(int boardNo) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("reply.deleteByBoardNo");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);
            
            result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 부모글에 해당하는 댓글 정보 가져오기
	 * */
	private List<CSReplyDTO> replyList(Connection con, int boardNo) throws SQLException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CSReplyDTO> replyList = new ArrayList<CSReplyDTO>();
		String sql = proFile.getProperty("reply.selectByBoardNo");
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				CSReplyDTO reply = new CSReplyDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				replyList.add(reply);
			}
			
		} finally {
			DBUtil.dbClose(null, ps, rs);
		}
		return replyList;
	}

	/**
	 * 부모글에 댓글 등록하기
	 * */
	@Override
	public int insertReply(CSReplyDTO reply) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("reply.insert");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, reply.getWriter());
            ps.setString(2, reply.getContent());
            ps.setInt(3, reply.getBoardNo());
            
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 댓글 수정
	 * */
	@Override
	public int replyUpdateByNo(CSReplyDTO reply) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("reply.updateByNo");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, reply.getContent());
            ps.setInt(2, reply.getReplyNo());
            
            result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 댓글 삭제
	 * */
	@Override
	public int replyDeleteByNo(int replyNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("reply.deleteByNo");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, replyNo);
            
            result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 가격표 전체 리스트 출력
	 * */
	@Override
	public List<Price> priceSelectAll() throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Price> list = new ArrayList<>();
		String sql = proFile.getProperty("price.selectAll");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				String grmType = rs.getString("grm_type");
				int bCost = rs.getInt("b_cost");
				int spcCost = rs.getInt("spc_cost");
				int grmTimes = rs.getInt("grm_times");
				
				Price price = new Price(grmType, bCost, spcCost, grmTimes);
				list.add(price);
			}
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	/**
	 * 가격표 레코드 입력
	 * */
	@Override
	public int priceInsert(Price price) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("price.insert");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, price.getGrmType());
            ps.setInt(2, price.getbCost());
            ps.setInt(3, price.getSpcCost());
            ps.setInt(4, price.getGrmTimes());
            
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 가격표 레코드 삭제
	 * */
	@Override
	public int priceDelete(String grmType) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("price.delete");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, grmType);
            
            result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

}
