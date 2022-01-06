package Algorithm_Challenge_Solutions;

import java.util.HashMap;
import java.util.Map;

public class Algorithm_Coding_Challenge_One {
    public static void main(String[] args) {
        System.out.println(solutionMap(new int[]{1, 4, 3, 5}, 7));
    }
    public static boolean solutionMap(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int remainder = target - arr[i];
            if (map.containsKey(remainder)){
                return true;
            }else {
                map.put(arr[i], i);
            }
        }
        return false;
    }
}
