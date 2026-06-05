package Oops;

//Create a Student class with
// fields (name, rollNo, marks)
// and display student details.

class O01_Student_Class {

    String name;
    int rollNo;
    double marks;

    //Non parameterized or No-argument constructor
    O01_Student_Class(){

    }

    //parameterized or argument constructor
    O01_Student_Class(String name, int rollNo, double marks){
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    void display(){
        System.out.println("Name: "+name + ", Roll No: "+rollNo +", Marks: "+marks);
    }

    public static void main(String[] args) {

        //parameterized or argument constructor
        O01_Student_Class s = new O01_Student_Class("Xxx", 1, 99.99);
        s.display();

        //Non parameterized or No-argument constructor
        O01_Student_Class s1 = new O01_Student_Class();
        s1.name = "Zzz";
        s1.rollNo = 2;
        s1.marks = 98.99;
        s1.display();
    }
}
