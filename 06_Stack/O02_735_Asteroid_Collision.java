package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class O02_735_Asteroid_Collision {
    public static void main(String[] args) {
        int[] asteroids = {5, 10,-5};
        System.out.println("Optimal: ");
        System.out.println(Arrays.toString(optimal(asteroids)));

        System.out.println("Brute: ");
        System.out.println(Arrays.toString(brute(asteroids)));
    }

    public static int[] optimal(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (Math.abs(ast) > stack.peek()) {
                    stack.pop(); // Destroy smaller positive asteroid
                } else if (Math.abs(ast) == stack.peek()) {
                    stack.pop(); // Both explode
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

//        Convert the stack to an array and return.
        return stack.stream().mapToInt(i -> i).toArray();

//          OR

//        int[] result = new int[stack.size()];
//        for (int i = 0; i < stack.size(); i++) {
//            result[i] = stack.get(i);
//        }
//        return result;

    }

    public static int[] brute(int[] asteroids){
        List<Integer> list = new ArrayList<>();
        for(int a : asteroids) list.add(a);

            boolean changed;

            do{
                changed = false;
                for(int i=0; i<list.size()-1; i++){
                    int left = list.get(i);
                    int right = list.get(i+1);

                    if(left>0 && right<0){
                        changed = true;
                        if(Math.abs(left) > Math.abs(right)){
                            list.remove(i+1);
                        }else if(Math.abs(left)<Math.abs(right)){
                            list.remove(i);
                        }else{
                            list.remove(i+1);
                            list.remove(i);
                        }
                        break;
                    }
                }
            }while(changed);

            int[] res = new int[list.size()];
            int idx = 0;
            for(int l : list){
                res[idx++] = l;
            }

            return res;
    }
}
