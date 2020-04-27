import java.util.Arrays;

public class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * Count the number of unique array elements
     * 
     * @param nums array
     * @return number of elements in the set created using nums array
     * 
     *         Time complexity : O(nlogn) Space complexity : O(1)
     */
    public static int getNumOfUniqueArrayElements(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 1) {
            return nums.length;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                count++;
            }
        }
        return count;
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
}