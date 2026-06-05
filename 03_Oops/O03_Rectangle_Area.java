package Oops;

//Write a program to
//calculate the area of a rectangle using a class.

class O03_Rectangle_Area {
    int len;
    int width;

    O03_Rectangle_Area(int len, int width){
        this.len = len;
        this.width = width;
    }

    double area(){
        return len*width;
    }

    public static void main(String[] args) {
        O03_Rectangle_Area area = new O03_Rectangle_Area(4, 5);
        System.out.println(area.area());
    }
}
