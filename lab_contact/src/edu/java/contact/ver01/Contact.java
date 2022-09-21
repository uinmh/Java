package edu.java.contact.ver01;

public class Contact {
    // field 
    // 이름 , 전화번호, 이메일
    private String name;
    private String phone;
    private String email;
    
    // 기본 생성자( default constructor (모든 변수를 null로 초기화)
    public Contact() {}
    
    //argument를 갖는 생성자
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    //getter/setter 메소드 생성.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    // 연락처 정보 출력기능
    
    public void printContact() {
        
        String info = String.format("Contact(name=%s, phone=%s, email=%s)", 
                this.name,this.phone,this.email);
        System.out.println(info);
    }
    
    
    
    
}
