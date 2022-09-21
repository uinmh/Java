package edu.java.modifier04;

/*
 * field 아이디,비밀번호
 * constructor : argument 2개를 갖는 생성자
 * method: 아이디 getter,  비밀번호 getter /setter 
 */

public class Member {
  
    private String id;
    private String pass;
    
    public Member(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }
    
    public String getId() {
        return this.id;
    }

    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        
        this.pass = pass;
        
    }
}

