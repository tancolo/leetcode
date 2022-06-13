import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumJava {
    public static void main(String[] args) {

        int[] nums = new int[] {3, 2, 4};
//        int[] nums = new int[] {3, 3};
//        int[] nums = new int[] {2, 7, 11 ,15};
        int target = 6;
        Arrays.stream(twoSumOnePassHashTable(nums, target)).forEach(
                System.out::println
        );
    }

    // simple approach
    public static int[] twoSumSimple(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }

        return null;
    }

    public static int[] twoSumOnePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
