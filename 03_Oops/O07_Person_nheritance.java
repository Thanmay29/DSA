package Oops;

//Inheritance:
//
//Create a Person class and
//extend it with Employee and Student classes.
//
//Implement Shape as a base class and
//extend it with Rectangle, Circle, Triangle.


////Note:
////We have 2 different main classes
////to run each seperatly
////right click on the main class you want to run
////and select run student/employee class


//Person class
class O07_Person_nheritance {
    String name;
    int age;

    void display(){
        System.out.println("Name: "+name+", Age: "+age);
    }
}

//Student class extends person
class Student extends O07_Person_nheritance {
    int grade;

    void display(){
        super.display();
        System.out.println("Grade: "+grade);
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println("Student:");
        s.name = "XXX";
        s.age = 20;
        s.grade = 8;
        s.display();

        System.out.println();

        Employee e = new Employee();
        System.out.println("Employee:");
        e.name = "ZZZ";
        e.age = 26;
        e.salary = 60000.00;
        e.display();
    }
}

//Employee class extends person
class Employee extends O07_Person_nheritance {
    double salary;

    void display(){
        super.display();
        System.out.println("Salary: "+salary);
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "ZZZ";
        e.age = 26;
        e.salary = 60000.00;
        e.display();
    }
}