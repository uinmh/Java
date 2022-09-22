package edu.java.inner02;

public class Button {
    // static inner interface
    
    public static interface OnclickListener {
        void onClick();  //추상 메서드 (public abstract 생략)
    }

    // field 
    private String btName;
    private OnclickListener listener;
    
    // Constructor
    
    public Button(String btnName) {
        this.btName = btnName;
    }
    
    // method
    public void setOnClickListener(OnclickListener l) {
        this.listener = l;        
    }
    
    public void click() {
        System.out.println(btName + " 버튼 :");
        listener.onClick();
    }
}
