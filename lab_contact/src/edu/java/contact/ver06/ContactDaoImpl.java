package edu.java.contact.ver06;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.proxy.annotation.Pre;

import static edu.java.contact.ver06.OracleConnection.*;
import static edu.java.contact.ver06.ContactSql.*;
import static edu.java.contact.ver06.Contact.Entity.*;
public class ContactDaoImpl implements ContactDao {

    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {}
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
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
    public List<Contact> select() {
   
        List<Contact> list = new ArrayList<>();// 리턴하기 위한 ArrayList - select의 결과를 저장.
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection(); // Oracle DB와 연결(접속)
            stmt = conn.prepareStatement(SQL_READ_ALL); // SQL 문장 준비
            
            rs = stmt.executeQuery(); // SQL 문장 실행
            while (rs.next()) { // ResultSet에 row 데이터가 있으면
                // row에서 각 column에 있는 값들을 분석
                Integer cid = rs.getInt(COL_CID);
                String title = rs.getString(COL_NAME);
                String content = rs.getString(COL_PHONE);
                String author = rs.getString(COL_EMAIL);
                
                // Blog 타입 객체 생성.
                Contact contact = new Contact(cid, title, content, author);
                list.add(contact); // 결과 ArrayList에 추가
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }

    @Override
    public Contact select(Integer cid) {
        
        Contact contact = null;
      
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1, cid);
            
            rs = stmt.executeQuery();
            if(rs.next()) {
                Integer no = rs.getInt(COL_CID);
                String name = rs.getString(COL_NAME);
                String phone = rs.getString(COL_PHONE);
                String email = rs.getString(COL_EMAIL);
                
                contact = new Contact(no, name, phone, email);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                closeResources(conn, stmt, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
                
        return contact;
    }

    @Override
    public int insert(Contact contact) {
      int result = 0;
    
      Connection conn = null;
      PreparedStatement stmt = null;
      
      try {
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_INSERT);
        
        stmt.setString(1, contact.getName());
        stmt.setString(2, contact.getPhone());
        stmt.setString(3, contact.getEmail());
        
        
        
        result = stmt.executeUpdate();
        
        System.out.println(" 추가 완료 되었습니다.");
        
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
    public int update(Contact contact) {
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            stmt.setInt(4, contact.getCid());
            
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return result;
    }

    @Override
    public int delete(Integer cid) {

        Connection conn = null;
           
        PreparedStatement stmt = null;

        int result = 0;
        
        try {
            conn = getConnection();
            
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cid);
            
            stmt.executeUpdate();
            
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

}
