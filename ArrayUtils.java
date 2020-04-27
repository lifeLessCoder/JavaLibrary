import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * Count the number of unique array elements
     * 
     * @param nums array
     * @return number of elements in the set created using nums array
     * 
     *         Time complexity : O(n) Space complexity : O(n)
     */
    public static int getNumOfDistinctEle(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size();
    }

    /**
     * Shift a given element to the last position
     * 
     * @param i    index of the element to be shifted
     * @param nums array
     * 
     *             Time complexity : O(n) Space complexity : O(1)
     */
    public static void shiftElementToLast(int i, int[] nums) {
        if (i < 0 || i >= nums.length) {
            return;
        }
        int cur = nums[i];
        for (int index = i + 1; index < nums.length; index++) {
            nums[index - 1] = nums[index];
        }
        nums[nums.length - 1] = cur;
    }

    /**
     * Swaps 2 elements given indices
     * 
     * @param nums array
     * @param i    first index
     * @param j    second index
     * 
     *             Time complexity : O(1) Space complexity : O(1)
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Remove duplicates in array. Store the resultant array in the input array
     * 
     * @param nums array
     * @return num of elements in the array after removing duplicates
     * 
     *         Time complexity : O(nlogn) Space complexity : O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int uPtr = 0;
        for (int ptr = 1; ptr < nums.length; ptr++) {
            if (nums[ptr] != nums[uPtr]) {
                uPtr++;
                swap(nums, ptr, uPtr);
            }
        }
        return uPtr + 1;
    }

    /**
     * Search an element in the given array
     * 
     * @param nums   array
     * @param target to find
     * @return index of target if present, else -1
     * 
     *         Time complexity : O(logn) Space complexity : O(1)
     */
    public static int binarySearch(int[] nums, int target) {
        int f = 0;
        int l = nums.length - 1;
        while (f <= l) {
            int m = f + (l - f) / 2;
            if (nums[m] == target) {
                return m;
            } else if (target < nums[m]) {
                l = m - 1;
            } else {
                f = m + 1;
            }
        }
        return -1;
    }

    /**
     * Get smallest element's index in a rotated sorted array
     * 
     * @param nums array
     * @return the index of the smallest element
     * 
     *         Time complexity : O(logn) Space complexity : O(1)
     */
    public static int getSmallestInRotatedSortedArray(int[] nums) {
        int f = 0;
        int l = nums.length - 1;
        int n = nums.length;
        while (f <= l) {
            int m = f + (l - f) / 2;
            if (m - 1 >= 0 && nums[m - 1] > nums[m]) {
                return m;
            }
            if (m + 1 < n && nums[m] > nums[m + 1]) {
                return m + 1;
            }
            if (nums[f] <= nums[m]) {
                f = m + 1;
            } else {
                l = m - 1;
            }
        }
        return -1;
    }
}