package Algorithm_Challenge_Solutions;

import java.util.Arrays;

public class Algorithm_Coding_Challenge_Two {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(firstAndLastIndex(new int[]{2,2,2,2, 4,4, 4, 4, 4, 6}, 4)));

    }
    public static int[] firstAndLastIndex(int[] arr, int key){

        String strOfInts = Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");

        return new int[]{strOfInts.indexOf(String.valueOf(key)), strOfInts.lastIndexOf(String.valueOf(key))};
    }
}
