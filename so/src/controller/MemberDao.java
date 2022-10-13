package controller;

import java.util.List;

import model.Member;

public interface MemberDao {
    
    
    List<Member> read();
    
    Member read(Integer memNo);
    
    int insert (Member mem);
    
    int update (Member mem);
    
    int delete(Integer mem);
    
    List<Member> read(int type, String keyword);
    
    
}
