package Oops;

//Encapsulation:
//
//Implement a Bank class with a
//private balance field and
//public methods to deposit and withdraw.
//Ensure the balance cannot be negative.

public class O09_Bank_Encapsulation {
    double balance;

//    O09_Encapsulation(double b){
//        this.balance = b;
//    }

    void deposit(double amount){
        if(amount<0) System.out.println("Invalid amount");
        balance+=amount;
    }

    void withdraw(double amount){
        if(balance<amount) System.out.println("Insufficient balance");
        else balance-=amount;
    }

    double getBalance(){
        return balance;
    }

    public static void main(String[] args) {
        O09_Bank_Encapsulation acc = new O09_Bank_Encapsulation();
        acc.deposit(1000);
        System.out.println("Balance: "+acc.getBalance());
        acc.withdraw(500);
        System.out.println("Balance: "+acc.getBalance());
        acc.withdraw(600);
    }
}
