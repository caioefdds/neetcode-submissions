class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // System.out.println("start="+start);
            // System.out.println("end="+end);
            // System.out.println("mid="+mid);

            if (nums[mid] == target) return mid;

            if (nums[start] > nums[mid]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target >= nums[start] && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
