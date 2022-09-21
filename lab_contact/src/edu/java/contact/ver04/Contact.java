package edu.java.contact.ver04;

import java.io.Serializable;

//MVC 아키텍쳐에서 Model에 해당하는 클래스. - 데이터를 정의하는 클래스
// ObjectInputStream, ObjectOutputStream에서 사용하려면 직렬화를 구현해야함.
public class Contact implements Serializable {

    //field 
    
    private String name;
    private String phone;
    private String email;
    
    
    //생성자
    
    public Contact() {}


    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }


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


    @Override
    public String toString() {
        return String.format("Contact(name=%s,phone=%s,email=%s)",
                name,phone,email);
    }
    
    
    
    
}
