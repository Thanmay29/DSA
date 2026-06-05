package Array;

public class O22_605_Can_Place_Flowers {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int n = 1; // flowers to be plantes
        //output = true  {1, 0, 1, 0, 1};
        //we cant have adjacent once(flowers);

        //input = {1,0,0,0,1};
        //if n = 2 // {1, 0, 1, 0, 1} // false
        //we still have one flower left

        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length && n>0 ; i++){
            if(flowerbed[i] == 0){

                boolean left = (i==0 || flowerbed[i-1] == 0);
                boolean right = (i==flowerbed.length-1 || flowerbed[i+1] == 0);

                if(left && right){
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n==0;
    }
}
