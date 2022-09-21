package edu.java.list04;

import java.util.Objects;

public class User {

    private String userId;
    private String password;

    // 생성자 : (1) 기본 생성자 (2) argument 2개를 갖는 생성자.

    public User() {

    }

    public User(String UserId, String password) {
        this.userId = UserId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
//        return "User [아이디=" + UserId + ", 비밀번호=" + password + "]";
        return String.format("User(userId=%s, password=%s)",this.userId,this.password);
   
    
    
    
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            return this.userId.equals(user.userId);
        }
        return false;
            
    }
    
}
