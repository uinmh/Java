package edu.java.inheritance01;

public class BasicTv {
    
    // field 속성
    private boolean powerOn;
    private int channel;
    private int volume;
    
    //getter setter 
    public boolean isPowerOn() {
        return powerOn;
    }
    
    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }
    
    public int getChannel() {
        return channel;
    }
    
    public void setChannel(int channel) {
        this.channel = channel;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    /**
     * powerOnOff. TV의 전원을 키거나 끄거나 하는 매서드.
     * TV의 현재 전원이 OFF이면 ON으로, ON이면 OFF로 변경을 해주는 매서드
     *
     * @return 전원이 ON이면 TURE, OFF이면 false를 리턴.
     */
    public boolean powerOnOff() {
        
        if (powerOn) { // tv가 켜져있으면
           powerOn = false;
           System.out.println("Tv Off");
        }else { // tv가 꺼져있으면
            powerOn = true;
           System.out.println("Tv On");
        }
        return powerOn;
    }
    
    
}
