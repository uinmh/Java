package edu.java.inner02;

import edu.java.inner02.Button.OnclickListener;

// Button.OnClickListener 인터페이스를 구현하는 클래스.
public class OpenButtonListener implements OnclickListener {
    
    @Override
    public void onClick() {
        System.out.print("파일열기");
    }
}
