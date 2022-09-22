package edu.java.inner02;

import edu.java.inner02.Button.OnclickListener;

public class InnerMain02 {

    public static void main(String[] args) {

        // Button 타입의 변수 선언, 객체 생성
        
        Button btnOpen = new Button("Open");
        
        // 생성된 버튼 객체의 setter 메서드를 호출 하려면
        // OnclickListener를 구현한 클래스의 객체를 argument로 전달 해야함
        OnclickListener l = new OpenButtonListener();
        btnOpen.setOnClickListener(l); // listener 변수 설정 -> 버튼이 해야 할 기능을 등록.
        btnOpen.click(); // 버튼 클릭 -> 버튼 클릭이 실행됨.
        
        // (1) 버튼을 생성한다.
        Button btnSave = new Button("SAVE");
        
        
        // 지역 내부 클래스(local class) : 메서드 안에서 선언(정의)된 클래스
        // -> 선언된 메서드 안에서만 사용 가능(생성자 호출).
        class SaveButtonListener implements OnclickListener{
            @Override
            public void onClick() {
                System.out.println("파일 저장");
            }
        }
        
       SaveButtonListener linstener = new SaveButtonListener();
       
       // (2) 버튼 클릭 기능 등록
       btnSave.setOnClickListener(linstener);
       // (3) 버튼 클릭 (기능 실행)
       btnSave.click();
       
       // (1) 버튼 생성 close
       
       Button btnClose = new Button("Close");
       
       
       // 익명 클레스 anonymous class)
       OnclickListener listener2 = new OnclickListener() {
        
        @Override
        public void onClick() {
            System.out.println("파일 닫기");
        }
    };
       // (2) 버튼 기능 등록        
       btnClose.setOnClickListener(listener2);
       // (3) 버튼 기능 실행
       btnClose.click();
       
       
       // (1) 버튼 생성 
       Button btnExit = new Button("EXIT");
       // (2) 버튼 기능 등록
       btnExit.setOnClickListener(new OnclickListener() {
        
        @Override
        public void onClick() {
            
            System.out.println("프로그램 종료");
        }
    });
       // (3) 버튼 실행
       btnExit.click();
    }

}
