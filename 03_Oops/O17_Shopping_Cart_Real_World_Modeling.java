package Oops;
import java.util.*;

//Create a ShoppingCart class
//with a list of Product objects and
//a method to calculate total price.

public class O17_Shopping_Cart_Real_World_Modeling {
    String name;
    double price;

    O17_Shopping_Cart_Real_World_Modeling(String name, double price){
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart{
    List<O17_Shopping_Cart_Real_World_Modeling> cart = new ArrayList<>();

    void addProduct(O17_Shopping_Cart_Real_World_Modeling p){
        cart.add(p);
    }

    double getTotal(){
        double sum = 0;
        for(O17_Shopping_Cart_Real_World_Modeling p : cart){
            sum+=p.price;
        }
        return sum;
    }

    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(new O17_Shopping_Cart_Real_World_Modeling("pen", 10));
        sc.addProduct(new O17_Shopping_Cart_Real_World_Modeling("NoteBook", 50));
        System.out.println("Total: "+ sc.getTotal());
    }
}
