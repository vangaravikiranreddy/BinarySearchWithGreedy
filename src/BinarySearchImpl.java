import java.util.Arrays;

public class BinarySearchImpl {
    public boolean isMaxDiff(int maxDiff, int[] nums, int p) {
        int n = nums.length;

        int curPair = 0;

        int index = 0;

        while (index < n - 1) {
            if (nums[index + 1] - nums[index] <= maxDiff) {
                curPair++;
                index++;
            }
            index++;
        }

        return (curPair >= p);
    }

    public int minimizeMax(int[] nums, int p) {
        if (p == 0 || nums.length == 1) {
            return p;
        }

        Arrays.sort(nums);

        int l = 0;
        int r = 1000000000;

        int diff = 0;

        while (l <= r) {
            int maxDiff = (l + r) / 2;

            if (isMaxDiff(maxDiff, nums, p)) {
                diff = maxDiff;
                r = maxDiff - 1;
            } else {
                l = maxDiff + 1;
            }
        }

        return diff;
    }
}
