package Oops;

//Create a Circle class with a
//method to calculate area and circumference.

class O05_Circle_Class {
    double radius;
    double pie = 3.14;

    O05_Circle_Class(double radius){
        this.radius = radius;
    }

    double area(){
        return pie*radius*radius;
    }

    double circumference(){
        return 2*pie*radius;
    }

    public static void main(String[] args) {
        O05_Circle_Class circle = new O05_Circle_Class(5.00);
        System.out.println("Area of the Circle: "+circle.area());
        System.out.println("circumference of the Circle: "+circle.circumference());
    }
}
