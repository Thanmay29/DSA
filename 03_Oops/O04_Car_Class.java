package Oops;

//Create a Car class with
// properties like brand, model,
// and methods like drive and stop.

class O04_Car_Class {

    String brand ;
    String model;

    O04_Car_Class(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    void drive(){
        System.out.println("Driving: "+brand+" "+model);
    }

    void stop(){
        System.out.println("Stopped");
    }

    public static void main(String[] args) {
        O04_Car_Class car = new O04_Car_Class("Toyota", "Corolla");
        car.drive();
        car.stop();
    }
}
