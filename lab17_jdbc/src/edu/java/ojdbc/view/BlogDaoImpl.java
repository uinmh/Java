package edu.java.ojdbc.view;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.ojdbc.controller.BlogDao;
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
    public List<Blog> select() {
        List<Blog> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Blog b) {
       
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
          
            DriverManager.registerDriver(new OracleDriver());
            
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
         
            String sql = String.format(
                    "insert into %s (%s, %s, %s) values (?, ?, ?)", 
                    TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_AUTHOR);
            System.out.println(sql);
            
           
            stmt = conn.prepareStatement(sql);
 
            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getContent());
            stmt.setString(3, b.getAuthor());
            
            int result = stmt.executeUpdate();

            System.out.println(result + "개 행이 삽입됐습니다.");
            
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
        return 1;
    }

    @Override
    public int update(Blog blog) {
    	
    	Connection conn = null;
        PreparedStatement stmt = null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = String.format(
                    "update %s set %s = ?, %s = ?, %s = sysdate where %s = ?", 
                    TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_MODIFIED_DATE, COL_BLOG_NO);
            System.out.println(sql);
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setInt(3, blog.getBlogNo());
            
            int result = stmt.executeUpdate();
            System.out.println(result + "개 행이 업데이트됐습니다.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    @Override
    public int delete(Integer blogNo) {
    	
    
    	
	Connection conn = null;
       
	PreparedStatement stmt = null;

	
	try {
        DriverManager.registerDriver(new OracleDriver());
            
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
        String sql = String.format(
                    "delete from %s where %s = ?",
                    TBL_BLOGS, COL_BLOG_NO );
        
        stmt = conn.prepareStatement(sql);   
              
        stmt.setInt(1, blogNo);
        
        System.out.println(blogNo);
        
        stmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        return 1;
    }

    @Override
    public List<Blog> select(int type, String keyword) {
        // TODO Auto-generated method stub
        return null;
    }

}