class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] response = new int[nums.length];

        response[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            response[i] = nums[i - 1] * response[i - 1];
        }

        // int[] response = new int[nums.length];
        // response[nums.length - 1] = leftToRight[nums.length - 1];

        int accumulated = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            accumulated *= nums[i + 1];
            response[i] = response[i] * accumulated;
        }

        return response;
    }
}