package com.air.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.air.dto.airInvenVO;
import com.air.dto.airMemberVO;
import com.air.dto.airSitVO;
import com.air.dto.airVO;

public class AirDAO {
	private AirDAO() {}
	
	private static AirDAO instance = new AirDAO();
	
	public static AirDAO getInstance() {
		return instance;
	}
	
	public List<airVO> selectAllAir(){
		String sql = "select * from air";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<airVO> list = new ArrayList<>();
		try {
			airVO vo = new airVO();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setLanding(rs.getString("landing"));
				vo.setBoarding(rs.getString("boarding"));
				vo.setStartpoint(rs.getString("startpoint"));
				vo.setDestination(rs.getString("destination"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
				
			}
		}catch(Exception e) {
			
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<airVO> selectSearchAir(String startpoint, String destination){
		String sql = "select * from air where startpoint=? and destination=?";
		ArrayList<airVO> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		airVO vo = new airVO();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startpoint);
			pstmt.setString(2, destination);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list = new ArrayList<>();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setLanding(rs.getString("landing"));
				vo.setBoarding(rs.getString("boarding"));
				vo.setStartpoint(rs.getString("startpoint"));
				vo.setDestination(rs.getString("destination"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public airVO selectSearchAir(String name){
		String sql = "select * from air where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		airVO vo = new airVO();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setLanding(rs.getString("landing"));
				vo.setBoarding(rs.getString("boarding"));
				vo.setStartpoint(rs.getString("startpoint"));
				vo.setDestination(rs.getString("destination"));
				vo.setPrice(rs.getInt("price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	public int loginCheck(String id, String pass) {
		int result = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from air_member where id = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(pass.equals(rs.getString("pass"))) {
					if(rs.getString("root").equals("B")) {
						result = 2; // 일반회원
					}
					if(rs.getString("root").equals("A")) {
						result = 1; // 관리자
					}
				}else {
					//비밀번호 불일치
					result = 0;
				}
			}else {
				//아이디 없음
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public airMemberVO getMember(String id) {
		String sql = "select * from air_member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		airMemberVO vo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new airMemberVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setKname(rs.getString("kname"));
				vo.setEname(rs.getString("ename"));
				vo.setEmail(rs.getString("email"));
				vo.setNum(rs.getInt("num"));
				vo.setPhone(rs.getString("phone"));
				vo.setPoint(rs.getInt("point"));
				vo.setRoot(rs.getString("root"));
				vo.setGender(rs.getString("gender"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	public List<airMemberVO> getMember() {
		String sql = "select * from air_member";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		airMemberVO vo = null;
		List<airMemberVO> list = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new airMemberVO();
				list = new ArrayList<>();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setKname(rs.getString("kname"));
				vo.setEname(rs.getString("ename"));
				vo.setEmail(rs.getString("email"));
				vo.setNum(rs.getInt("num"));
				vo.setPhone(rs.getString("phone"));
				vo.setPoint(rs.getInt("point"));
				vo.setRoot(rs.getString("root"));
				vo.setGender(rs.getString("gender"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int confirmID(String id) {
		int result = 0;
		String sql = "select id from air_member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = -1;
			}else {
				result = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	public void joinMember(airMemberVO vo) {
		String sql = "insert into air_member(num,id,pass,kname,ename,phone,email,gender) values(air_mem_seq.nextval,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getKname());
			pstmt.setString(4, vo.getEname());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getGender());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void UpdateMember(airMemberVO vo) {
		String sql = "update air_member set pass=?,kname=?,ename=?,phone=?,email=?,gender=? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getKname());
			pstmt.setString(3, vo.getEname());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void createMemberInventory(airMemberVO vo) {
		String sql = "insert into air_member_inventory(num,id) values(mem_inven_seq.nextval,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void tiketing(String air_name, String id) {
		String sql = null;
	}
	
	public List<airSitVO> getSitInfo() {
		String sql = "select name, status from air_sit";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		airSitVO vo = null;
		List<airSitVO> list = new ArrayList<airSitVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new airSitVO();
				vo.setName(rs.getString("name"));
				vo.setStatus(rs.getString("status"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void updateInventory(airInvenVO vo) {
		String sql = "update air_member_inventory set air_name = ?, air_sit = ?, tiket = 'Y', pay = ? where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAir_name());
			pstmt.setString(2, vo.getAir_sit());
			pstmt.setString(3, vo.getPay());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void insertInventory(airInvenVO vo) {
		String sql = "insert into air_member_inventory values(mem_inven_seq.nextval,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getAir_name());
			pstmt.setString(3, vo.getAir_sit());
			pstmt.setString(4, "Y");
			pstmt.setString(5, vo.getPay());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void deleteInventory(String id, String air_sit, String name) {
		String sql = "delete from air_member_inventory where id=? and air_sit=? and air_name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, air_sit);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateAirSitStatusY(String air_sit) {
		String sql = "update air_sit set status = 'Y' where name = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, air_sit);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateAirSitStatusN(String air_sit) {
		String sql = "update air_sit set status = 'N' where name = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, air_sit);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public List<airMemberVO> memberTiketInfo(String id){
		String sql = "select * from air_member m inner join air_member_inventory i on m.id = i.id where m.id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<airMemberVO> list = new ArrayList<>();
		airMemberVO vo = new airMemberVO();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setKname(rs.getString("kname"));
				vo.setEname(rs.getString("ename"));
				vo.setAir_name(rs.getString("air_name"));
				vo.setAir_sit(rs.getString("air_sit"));
				vo.setPay(rs.getString("pay"));
				vo.setRoot(rs.getString("root"));
				vo.setTiket(rs.getString("tiket"));
				vo.setPhone(rs.getString("phone"));
				vo.setId(id);
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<airMemberVO> memberTiketInfoAll(){
		String sql = "select * from air_member m inner join air_member_inventory i on m.id = i.id";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<airMemberVO> list = new ArrayList<>();
		airMemberVO vo = new airMemberVO();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setKname(rs.getString("kname"));
				vo.setEname(rs.getString("ename"));
				vo.setAir_name(rs.getString("air_name"));
				vo.setAir_sit(rs.getString("air_sit"));
				vo.setPay(rs.getString("pay"));
				vo.setRoot(rs.getString("root"));
				vo.setTiket(rs.getString("tiket"));
				vo.setPhone(rs.getString("phone"));
				vo.setId(rs.getString("id"));
				vo.setPoint(rs.getInt("point"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<airVO> selectAirName(String name){
		String sql = "select * from air where name = ?";
		ArrayList<airVO> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		airVO vo = new airVO();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list = new ArrayList<>();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setLanding(rs.getString("landing"));
				vo.setBoarding(rs.getString("boarding"));
				vo.setStartpoint(rs.getString("startpoint"));
				vo.setDestination(rs.getString("destination"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
