package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helperPermutation(0, nums, result);
        return result;
    }
    // help online from w3resource.com
    private static void helperPermutation(int n, int[] nums, List<List<Integer>> perm) {
        if (n == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums){
                list.add(i);
            }
            perm.add(list);
        } else {
            for (int j = n, l = nums.length; j < l; j++) {
                int temp = nums[j];
                nums[j] = nums[n];
                nums[n] = temp;
                helperPermutation(n + 1, nums, perm);
                temp = nums[j];
                nums[j] = nums[n];
                nums[n] = temp;
            }
        }
    }


}
