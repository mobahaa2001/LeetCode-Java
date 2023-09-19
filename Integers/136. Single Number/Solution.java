// Asked by Amazon
class Solution {
    public int singleNumber(int[] nums) {
        
    /* ----------Solution 1---------- */

        if (nums.length ==1)
            return nums[0];

        Set<Integer> set = new HashSet<>();
        for (int i =0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();

        /* ----------Solution 2---------- */
        int ans = nums[0];
        for (int i =1; i <nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;

    }
} // TC: O(n), SC: O(n) --> O(1)