package Oops;

//Implement a class for a calculator
// (add, subtract, multiply, divide).

class O06_Calculator {
    double num1;
    double num2;

    O06_Calculator(double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    double add(){
        return num1+num2;
    }

    double sub(){
        return num1-num2;
    }

    double mul(){
        return num1*num2;
    }

    double div(){
        if(num2 <= 0){
            System.out.println("Cant divide by 0 should be greater than 0");
        }
        return num1/num2;
    }

    public static void main(String[] args) {
        O06_Calculator cal = new O06_Calculator(4, 0);
        System.out.println(cal.div());
    }
}
