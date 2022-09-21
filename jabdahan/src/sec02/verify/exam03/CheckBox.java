package sec02.verify.exam03;

public class CheckBox {

    OnselectListener listener;
    
    void setOnSelectListener(OnselectListener listener) {
        this.listener = listener;
    }
    
    void select() {
        listener.onSelect();
    }
    
    static interface OnselectListener {
        void onSelect();
    }
}
