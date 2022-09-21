package edu.java.class02;


// 클래스의 멤버들 :
// 1. 필드 (field) - 클래스의 객체들이 가질 수 있는 속성들(데이터). 변수.
// 2. 생성자(constructor) - 객체를 생성하고 초기화.
// 3. 메서드(method) -  클래스의 객체들이 갖는 기능(함수).

public class Product { // 쇼핑몰에서 사용할 상품들의 정보를 저장하려하는 그런 클레스
    
    // field 
    int productId; // 상품의 아이디
    String productName; // 상품의 이름
    int price; // 상품 가격
    
     
    //constructor( 생성자 )
    
    public Product (int productId, String productName, int price) {
        this.productId = productId; 
        this.productName = productName;
        this.price = price;
    }
    
    //method
    
    public void setPrice(int price) {
        
        this.price = price;
        
    }
    
    
}
