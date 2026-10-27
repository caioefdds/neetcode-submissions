class Solution {
    public boolean searchInLine(int[] line, int target) {
        int start = 0;
        int end = line.length;

        while (end > start) {
            int mid = start + (end - start) / 2;

            if (line[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return line[start] == target;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (end >= start) {
            int mid = start + (end - start) / 2;
            int[] line = matrix[mid];

            if (line[0] <= target && line[line.length - 1] >= target) {
                return searchInLine(line, target);
            } else if (line[0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
