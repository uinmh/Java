package controller;

import java.util.List;

import model.Member;

public interface MemberDao {
	
    List<Member> read();
    
    Member read(Integer memNo);
    
    int insert (Member mem);
    
    int update (Member mem);
    
    int delete(Integer memNo);
    
    List<Member> read(int type, String keyword);
    
   // ========================
    
    List<Member>readNotice();

    Member readNotice(Integer noticeNo);
    
    int insertNotice (Member mem);
    
    int updateNotice (Member mem);
    
    int deleteNotice(Integer mem);
    
    List<Member> readNotice(int type, String keyword);
    
    
}

