package edu.java.ojdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.ojdbc.model.Blog;
import edu.java.ojdbc.view.BlogMain;
import oracle.jdbc.driver.OracleDriver;

import static edu.java.ojdbc.OracleJdbc.*;
import static edu.java.ojdbc.controller.JdbcSql.*;
import static edu.java.ojdbc.model.Blog.Entity.*;

public class BlogDaoImpl implements BlogDao {
    // Singleton 적용
    private static BlogDaoImpl instance = null;
    
    private BlogDaoImpl() {}
    
    public static BlogDaoImpl getInstance() {
        if (instance == null) {
            instance = new BlogDaoImpl();
        }
        
        return instance;
    }

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver()); 

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void closeResources(Connection conn, Statement stmt) 
            throws SQLException {
        stmt.close();
        conn.close();
    }

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) 
            throws SQLException {
        rs.close();
        closeResources(conn, stmt);
    }
    
    @Override
    public List<Blog> select() {
        List<Blog> list = new ArrayList<>();// 리턴하기 위한 ArrayList - select의 결과를 저장.
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection(); // Oracle DB와 연결(접속)
            stmt = conn.prepareStatement(SQL_SELECT_ALL); // SQL 문장 준비
            
            rs = stmt.executeQuery(); // SQL 문장 실행
            while (rs.next()) { // ResultSet에 row 데이터가 있으면
                // row에서 각 column에 있는 값들을 분석
                Integer blogNo = rs.getInt(COL_BLOG_NO);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime created = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modified = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                
                // Blog 타입 객체 생성.
                Blog blog = new Blog(blogNo, title, content, author, created, modified);
                list.add(blog); // 결과 ArrayList에 추가
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
    public Blog select(Integer blogNo) {
        
        Blog blog = null; //DB에서 검색한 리턴할 객체.
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            
            stmt = conn.prepareStatement(SQL_SELECT_BY_NO);
            stmt.setInt(1, blogNo);
            
            rs = stmt.executeQuery();
            if(rs.next()) { // 검색 결과에서 row 데이터가 있으면
                Integer no = rs.getInt(COL_BLOG_NO);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime created = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modified = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                blog = new Blog(blogNo, title, content, author, created, modified);
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
        
        
        return blog;
    }

    @Override
    public int insert(Blog blog) {
       
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            
            conn = getConnection();
            
            stmt = conn.prepareStatement(SQL_INSERT);
 
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setString(3, blog.getAuthor());
            
            result = stmt.executeUpdate();

            System.out.println(result + "개 행이 삽입됐습니다.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
   
            try {
              closeResources(conn, stmt);
              
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int update(Blog blog) {
    	
        int result = 0;
    	Connection conn = null;
        PreparedStatement stmt = null;
        
        try {

            conn = getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setInt(3, blog.getBlogNo());
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
            try {
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int delete(Integer blogNo) {

	Connection conn = null;
       
	PreparedStatement stmt = null;

	int result = 0;
	
	try {
        conn = getConnection();
                
        stmt = conn.prepareStatement(SQL_DELETE);   
              
        stmt.setInt(1, blogNo);
        
        stmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Blog> select(int type, String keyword) {
        
        List<Blog> list = new ArrayList<>();
                
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
                
        try {
            conn = getConnection();
            
            switch (type) {
            
            case 0: // 제목검색
                System.out.println(SQL_SELECT_BY_TITLE);
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                break;
            case 1: // 내용검색
                System.out.println(SQL_SELECT_BY_CONTENT);
                stmt = conn.prepareStatement(SQL_SELECT_BY_CONTENT);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                break;
            case 2: // 제목 또는 내용 검색
                System.out.println(SQL_SELECT_BY_TITLE_OR_CONTENT);
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_CONTENT);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                stmt.setString(2, "%" + keyword.toLowerCase() + "%");
                break;
                
            case 3: // 작성자 검색
                System.out.println(SQL_SELECT_BY_AUTHOR);
                stmt = conn.prepareStatement(SQL_SELECT_BY_AUTHOR);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                break;
                
            default :
            }
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer blogNo = rs.getInt(COL_BLOG_NO);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime created = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modified = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                
                Blog blog = new Blog(blogNo, title, content, author, created, modified);
                list.add(blog);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                closeResources(conn, stmt, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
        
        return list;
    }

}