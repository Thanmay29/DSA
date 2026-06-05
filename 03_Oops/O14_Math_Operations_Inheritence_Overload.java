package Oops;

///Polymorphism (Method Overriding & Overloading):
//Overloading
//Implement a MathOperations class with
//overloaded methods for addition (int, float, double).


public class O14_Math_Operations_Inheritence_Overload {

    int add(int a, int b){ return a+b; }

    float add(float a,float b){ return a+b; }

    double add(double a, double b){ return a+b; }

    public static void main(String[] args) {
        O14_Math_Operations_Inheritence_Overload mo = new O14_Math_Operations_Inheritence_Overload();
        System.out.println("Int sum: "+ mo.add(7,7));
        System.out.println("Float sum: "+ mo.add(7.7f,7.7f));
        System.out.println("Double sum: "+ mo.add(7.7777, 7.777));
    }

}
