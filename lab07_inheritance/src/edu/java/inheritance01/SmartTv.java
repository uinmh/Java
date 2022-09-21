package edu.java.inheritance01;


// SmartTv = TV이다. (Smart TV "IS A" TV)
// BasicTv: super/parent/base 클래스
// SmartTv: sub/child/derived 클래스
public class SmartTv extends BasicTv {
    
    // field(속성)
    private String ip;

    // getter setter
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    
    
}
