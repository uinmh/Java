package Ex;

public class Car {


    String model;
    int speed;
    
    Car(String model){
    this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    void run() {
        for(int i = 10; i <= 60; i+=10) {
            this.setSpeed(i);
            System.out.println(this.model + "가 달립니다." + ("시속 " + this.speed + " km/h"));
        }
    }

    }


