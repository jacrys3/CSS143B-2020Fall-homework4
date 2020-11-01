package Problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList perm = new ArrayList<>();
        ArrayList data = new ArrayList(Arrays.asList(nums));
        helperPermute(data, perm, nums.length);
        return perm;
    }
    private static void helperPermute(ArrayList nums, ArrayList perm, int n){
        if(n == 1){
            perm.add(nums);
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            helperPermute(nums, perm, n - 1);
            if(n % 2 == 0){
                swap(nums, i, n-1);
                perm.add(nums);
            } else{
                swap(nums, 0, n-1);
                perm.add(nums);
            }
        }
    }
    private static void swap(ArrayList nums, int p1, int p2){
        int tmp = (int) nums.get(p1);
        nums.set(p1, nums.get(p2));
        nums.set(p1, tmp);
    }
}
