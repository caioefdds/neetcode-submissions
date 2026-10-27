class Solution {
    private int ATLANTIC = 1;
    private int PACIFIC = 2;
    private int BOTH = 3;
    private int[][] DIRECTIONS = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    private void flow(int[][] heights, int row, int col, int ocean, int[][] oceans) {
        if (oceans[row][col] == ocean || oceans[row][col] == BOTH) {
            return;
        }

        oceans[row][col] += ocean;

        for (int[] direction : DIRECTIONS) {
            int nRow = row + direction[0];
            int nCol = col + direction[1];

            if (
                nRow < 0 ||
                nCol < 0 ||
                nRow >= heights.length ||
                nCol >= heights[0].length ||
                heights[row][col] > heights[nRow][nCol] ||
                oceans[nRow][nCol] == ocean ||
                oceans[nRow][nCol] == BOTH
            ) continue;
            flow(heights, nRow, nCol, ocean, oceans);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] oceans = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 || col == 0) {
                    flow(heights, row, col, PACIFIC, oceans);
                }

                if (row == rows - 1 || col == cols - 1) {
                    flow(heights, row, col, ATLANTIC, oceans);
                }
            }
        }

        List<List<Integer>> response = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int ocean = oceans[row][col];

                if (ocean == BOTH) {
                    response.add(List.of(row, col));
                }
            }
        }

        return response;
    }
}
