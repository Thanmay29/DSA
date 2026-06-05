package Oops;

//Create a BankAccount class
//with deposit and withdraw methods.

class O02_Bank_Account_Class {
    private double balance;

    void deposite(double amount){
        balance+=amount;
    }

    void withdraw(double amount){
        if(balance>=amount) balance -=amount;
        else System.out.println("insufficient balance");
    }

    double getBalance(){
        return balance;
    }

    public static void main(String[] args) {
        O02_Bank_Account_Class acc = new O02_Bank_Account_Class();
        acc.deposite(1000);
        System.out.println("Balance: "+ acc.getBalance());
        acc.withdraw(500);
        System.out.println("Balance: "+ acc.getBalance());
        acc.withdraw(600);
    }
}
