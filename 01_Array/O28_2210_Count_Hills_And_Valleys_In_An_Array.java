package Array;

import java.util.ArrayList;
import java.util.List;

public class O28_2210_Count_Hills_And_Valleys_In_An_Array {

    public static int countHillValley(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[i-1]){
                list.add(nums[i]);
            }
        }

        int count = 0;

        for(int i=1; i<list.size()-1; i++){
            int prev = list.get(i-1);
            int curr = list.get(i);
            int next = list.get(i+1);

            if((curr>prev && curr>next) || (curr<prev && curr<next)){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {2,4,1,1,6,5};
        System.out.println(countHillValley(nums));
    }
}
