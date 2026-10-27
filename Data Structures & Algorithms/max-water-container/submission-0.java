class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int maxArea = 0;

        while (left < right) {
            int leftBar = heights[left];
            int rightBar = heights[right];

            int minHeight = Math.min(leftBar, rightBar);
            int distance = right - left;

            maxArea = Math.max(maxArea, minHeight * distance);

            if (leftBar >= rightBar) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}
