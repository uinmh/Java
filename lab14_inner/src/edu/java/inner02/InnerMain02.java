package edu.java.inner02;

import edu.java.inner02.Button.OnclickListener;

public class InnerMain02 {

    public static void main(String[] args) {

        // Button 타입의 변수 선언, 객체 생성
        
        Button btnOpen = new Button("Open");
        
        // 생성된 버튼 객체의 setter 메서드를 호출 하려면
        // OnclickListener를 구현한 클래스의 객체를 argument로 전달 해야함
        OnclickListener l = new OpenButtonListener();
        btnOpen.setOnClickListener(l);
        btnOpen.click();
    }

}
