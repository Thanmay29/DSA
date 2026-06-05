package Recursion;

public class O08_Subsets_String {

    public static void subset(String s, int i, String curr){

        if(i==s.length()){
            System.out.println(curr);
            return;
        }

        //Exclude
        subset(s, i+1, curr);

        //Include
        subset(s, i+1, curr+s.charAt(i));
    }

    static void main() {
        String s = "abc";

        subset(s, 0, "");
    }
}
