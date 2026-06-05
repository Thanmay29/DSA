package Oops;

//Inheritence

//Implement Shape as a base class and
//extend it with Rectangle, Circle, Triangle.


////Note:
////We have 2 different main classes
////to run each seperatly
////right click on the main class you want to run
////and select run any class


//Shape Class
abstract class O08_Shape_Inheritence {
    abstract double area();
}


//Circle Class
class Circle extends O08_Shape_Inheritence{
    double radius;

    Circle(double radius){
        this.radius = radius;
    }

    double area(){
        return Math.PI * radius*radius;
    }

    public static void main(String[] args) {
        Circle c = new Circle(7.77);
        System.out.println("Circle area: "+c.area());

        Rectangle r = new Rectangle(7.7, 7.7);
        System.out.println("Rectangle area: "+r.area());

        Triangle t = new Triangle(7.77, 7.77);
        System.out.println("Triangle area: "+t.area());
    }
}


//Rectangle Class
class Rectangle extends O08_Shape_Inheritence{
    double len,width;

    Rectangle(double l, double w){
        len = l; width = w;
    }

    double area(){ return len*width; }
}

//Triangle Class
class Triangle extends O08_Shape_Inheritence{
    double breadth, height;

    Triangle(double b, double h){ breadth=b; height=h; }

    double area(){ return 0.5 * breadth*height; }

    public static void main(String[] args) {
        Triangle t = new Triangle(7.77, 7.77);
        System.out.println("Triangle area: "+t.area());
    }
}


