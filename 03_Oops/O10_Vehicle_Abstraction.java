package Oops;

//Abstraction (Using Abstract Classes and Interfaces):
//
//Create an abstract class Vehicle with an
//abstract method startEngine().
//Implement in classes like Car, Bike.

abstract class O10_Vehicle_Abstraction {
    abstract void startEngine();
}

class Car extends O10_Vehicle_Abstraction{
    void startEngine(){
        System.out.println("Car engine started");
    }

    public static void main(String[] args) {
        Car c = new Car();
        c.startEngine();

        Bike b = new Bike();
        b.startEngine();
    }
}

class Bike extends O10_Vehicle_Abstraction{
    void startEngine(){
        System.out.println("Bike engine started");
    }
}
