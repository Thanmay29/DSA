package Oops;

//Static Members:
//
//Create a class Counter with a static variable
//that counts how many objects are created.
//

//this is a counter class
class O15_Static_Members {
    static int count = 0;

    O15_Static_Members(){
        count++;
    }

    public static void main(String[] args) {
        new O15_Static_Members();
        new O15_Static_Members();
        System.out.println("Objects created: "+ O15_Static_Members.count);
    }
}
