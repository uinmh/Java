package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import model.Member;
import static ojdbc.OracleJdbc.*;
import static model.Member.Entity.*;
import static controller.JdbcSql.*;
import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.proxy.annotation.Pre;

public class MemberDaoImpl implements MemberDao {
 
	  // Singleton 적용
    private static MemberDaoImpl instance = null;
    
    private MemberDaoImpl() {}
    
    public static MemberDaoImpl getInstance() {
        if (instance == null) {
            instance = new MemberDaoImpl();
        }
        
        return instance;
    }

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void closeResources(Connection conn, Statement stmt) throws SQLException {
        stmt.close();
        conn.close();
    }

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) 
            throws SQLException {
        rs.close();
        closeResources(conn, stmt);
    }
	@Override
	public List<Member> read() {

		List<Member> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				
	            Integer memId = rs.getInt(COL_MEM_ID);
	            Date memJoinDay = rs.getDate(COL_MEM_JOINDAY);
	            Date memBirthDay = rs.getDate(COL_MEM_BIRTHDAY);
	            String memName = rs.getString(COL_MEM_NAME);
	            String memPhone = rs.getString(COL_MEM_PHONE);
	            String memCity = rs.getString(COL_MEM_CITY);
	            String memQ = rs.getString(COL_MEM_Q);
	            
	            Member member = new Member(memId, memJoinDay, memBirthDay, memName, memPhone, memCity, memQ);
	            
	            list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

    return list;
  
	}

	@Override
	public Member read(Integer memNo) {
		Member member = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, memNo);
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				Date memJoinDay = rs.getDate(COL_MEM_JOINDAY);
	            Date memBirthDay = rs.getDate(COL_MEM_BIRTHDAY);
	            String memName = rs.getString(COL_MEM_NAME);
	            String memPhone = rs.getString(COL_MEM_PHONE);
	            String memCity = rs.getString(COL_MEM_CITY);
	            String memQ = rs.getString(COL_MEM_Q);
	          
	            member = new Member(memNo, memJoinDay, memBirthDay, memName, memPhone,
	        		  memCity, memQ);
	           
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
				System.out.println("구간체크 f");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}

	@Override
	public int insert(Member mem) {
	    
	    int result = 0;
	    
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    
	    try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, mem.getMemName());
            stmt.setString(2, mem.getMemCity());
            stmt.setString(3, mem.getMemPhone());
            stmt.setDate(4, mem.getMemBirthDay());
            stmt.setString(5, mem.getMemQ());
                    
            result = stmt.executeUpdate();
            
	    } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
          try {
            closeResources(conn, stmt);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        }
	    
		
		return result;
	}

	@Override
	public int update(Member mem) {
      int result = 0;
      Connection conn = null;
      PreparedStatement stmt = null;
      
      try {
          conn = getConnection();
          stmt = conn.prepareStatement(SQL_UPDATE);
          System.out.println("구간체크 m");
          stmt.setDate(1, mem.getMemJoinDay());
          stmt.setDate(2, mem.getMemBirthDay());
          stmt.setString(3, mem.getMemName());
          stmt.setString(4, mem.getMemPhone());
          stmt.setString(5, mem.getMemCity());
          stmt.setString(6, mem.getMemQ());
          stmt.setInt(7,mem.getMemberId());
          
          result = stmt.executeUpdate();
          
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      } finally {
          try {
              closeResources(conn, stmt);
              System.out.println("구간체크f2");
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
      }
      return result;
	}

	@Override
	public int delete(Integer mem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Member> read(int type, String keyword) {
		List<Member> list = new ArrayList<>();
	    
	    Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
            conn = getConnection();
            
            switch (type){
            case 0: // 이름 
                stmt = conn.prepareStatement(SQL_SELECT_BY_NAME);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                break;
            case 1: //  지역 
                stmt = conn.prepareStatement(SQL_SELECT_BY_CITY);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                break;
            case 2: // 전화번호검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_PHONE);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                break;
            case 3: // 가입일 검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_JOINDAY);
                stmt.setString(1, keyword.toLowerCase());
                break;
            case 4: // 생년월일 검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_BIRTHDAY);
                stmt.setString(1, keyword.toLowerCase());
                break;
            default:
            }
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer memId = rs.getInt(COL_MEM_ID);
                Date memJoinDay = rs.getDate(COL_MEM_JOINDAY);
                Date memBirthDay = rs.getDate(COL_MEM_BIRTHDAY);
                String memName = rs.getString(COL_MEM_NAME);
                String memPhone = rs.getString(COL_MEM_PHONE);
                String memCity = rs.getString(COL_MEM_CITY);
                String memQ = rs.getString(COL_MEM_Q);
                
                Member member = new Member(memId, memJoinDay, memBirthDay, memName, memPhone, memCity, memQ);
                list.add(member);
            }
            
            
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
          try {
            closeResources(conn, stmt, rs);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        }
		
		return list;
	}

    @Override
    public List<Member> readNotice() {
        
   List<Member> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            
            stmt = conn.prepareStatement(SQL_SELECT_BY_NOTICE);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Integer noticeNo = rs.getInt(COL_NOTICE_NO);
                Date LocalDate = rs.getDate(COL_LOCAL_DATE);
                Date modifieDate = rs.getDate(COL_MODIFIE_DATE);
                String noticeName = rs.getString(COL_MEM_NAME_NOTICE);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                
              Member member = new Member(noticeNo, title, content, noticeName, LocalDate, modifieDate);
                
                list.add(member);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        

    return list;
    }

    @Override
    public Member readNotice(Integer noticeNo) {
   
        
        Member member = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_NOTICE_NO);
            stmt.setInt(1, noticeNo);
            
            rs = stmt.executeQuery();
            if(rs.next()) {
                Integer No = rs.getInt(COL_NOTICE_NO);
                Date LocalDate = rs.getDate(COL_LOCAL_DATE);
                Date modifieDate = rs.getDate(COL_MODIFIE_DATE);
                String noticeName = rs.getString(COL_MEM_NAME_NOTICE);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
              
                member = new Member(noticeNo, title, content, noticeName, LocalDate, modifieDate);
                
                
               
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return member;
    }
    
    
    @Override
    public int insertNotice(Member mem) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateNotice(Member mem) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteNotice(Integer mem) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Member> readNotice(int type, String keyword) {
        // TODO Auto-generated method stub
        return null;
    }


}
