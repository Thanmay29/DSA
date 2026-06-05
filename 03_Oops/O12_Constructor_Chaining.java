package Oops;

//Constructor Chaining:
//
//Create a class with multiple constructors
//and use this() to chain them.
//
public class O12_Constructor_Chaining {
    O12_Constructor_Chaining(){
        this(5);
        System.out.println("Default constructor");
    }

    O12_Constructor_Chaining(int x){
        System.out.println("Parameterized consructor: "+x);
    }

    public static void main(String[] args) {
        O12_Constructor_Chaining c = new O12_Constructor_Chaining();
    }
}
