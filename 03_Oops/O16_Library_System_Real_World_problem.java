package Oops;

//Real-world modeling:
//(Basic)
//Design a class system for a
//Library Management System (Book, Member, Librarian).

public class O16_Library_System_Real_World_problem {
    String title, author;
}

class Member{
    String name;
}

class Librarian{
    String name;

    public static void main(String[] args) {
        O16_Library_System_Real_World_problem lib = new O16_Library_System_Real_World_problem();

        lib.title = "XXX";
        lib.author = "XYZ";
        System.out.println("Book: "+lib.title+", Author: "+lib.author);
    }
}
