package edu.java.inheritance06;

public class User {

    // field :사용자 아이디
    private String id;
    private String pass;

    public User() {

    }

    public User(String id, String pass) {
        this.id = id;
        this.pass = pass;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override // 아이디와 비밀번호가 출력 될수 있도록.
    public String toString() {
       return String.format("아이디 : %s , 비밀번호 : %s ", id, pass); 
    }

    @Override // 아이디가 일치하는 User 객체는 같은객체.
    public boolean equals(Object obj) {
        
        boolean result = false;

        if (obj instanceof User) {
            User us = ((User) obj);
            result = (this.id.equals(us.id));
        }
        
        return result;
    }

    @Override // 아이디가 같으면 해쉬코드(int)도 같으면됨.
    public int hashCode() {

        return this.id.hashCode();
    }

}
