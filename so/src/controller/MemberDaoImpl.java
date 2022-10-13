package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import static Ojdbc.OracleJdbc.*;
import static model.Member.Entity.*;
import static controller.JdbcSql.*;
import oracle.jdbc.driver.OracleDriver;


public class MemberDaoImpl implements MemberDao {
    
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
    public List<Member> read() {
        
        List<Member> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            
            rs = stmt.executeQuery();
        
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
        
        
    return null;
    }

    @Override
    public Member read(Integer memNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Member mem) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Member mem) {
//        int result = 0;
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        
//        try {
//            conn = getConnection();
//            stmt = conn.prepareStatement(SQL_UPDATE);
//            
//            stmt.setString(1, mem.getMemJoinDay().toString());
//            stmt.setString(2, mem.getMemBirthDay().toString());
//            stmt.setString(3, mem.getMemName());
//            stmt.setString(4, mem.getMemPhone());
//            stmt.setString(5, mem.getMemCity());
//            stmt.setString(6, mem.getMemQ());
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            try {
//                closeResources(conn, stmt);
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
        return 0;
    }

    @Override
    public int delete(Integer mem) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Member> read(int type, String keyword) {
        // TODO Auto-generated method stub
        return null;
    }

}
