package Oops;

//Polymorphism (Method Overriding & Overloading):
//Overriding
//Create a class Animal with a
//method makeSound() and
//override it in subclasses like Dog, Cat.

public class O13_Animal_Polymorphism_Override {
    void makeSound(){
        System.out.println("animal makes Sound...");
    }
}

class Dog extends O13_Animal_Polymorphism_Override {
    //Overriding main animal class makeSound
    void makeSound(){
        System.out.println("Dog Bark...");
    }

    public static void main(String[] args) {

        //Original main class without overriding
        O13_Animal_Polymorphism_Override a = new O13_Animal_Polymorphism_Override();
        a.makeSound();

        //Dog class overriding animal class
        O13_Animal_Polymorphism_Override d = new Dog();
        d.makeSound();

        //cat class overriding animal class
        O13_Animal_Polymorphism_Override c = new cat();
        c.makeSound();
    }
}

class cat extends O13_Animal_Polymorphism_Override{
    //Overriding main animal class makeSound
    void makeSound(){
        System.out.println("Cat Meow...");
    }
}
