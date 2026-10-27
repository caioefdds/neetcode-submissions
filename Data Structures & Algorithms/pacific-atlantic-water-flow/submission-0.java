class Solution {
    private final int[][] DIRECTIONS = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    private final int PACIFIC = 1;
    private final int ATLANTIC = 2;
    private final int BOTH = 3;

    private void walk(int[][] heights, int row, int col, int[][] visited, int ocean) {
        if (visited[row][col] == ocean || visited[row][col] == BOTH) return;

        visited[row][col] += ocean;

        for (int[] direction : DIRECTIONS) {
            int nRow = row + direction[0];
            int nCol = col + direction[1];

            if (nRow < 0 || nCol < 0 || nRow >= heights.length || nCol >= heights[0].length || heights[row][col] > heights[nRow][nCol]) continue;

            walk(heights, nRow, nCol, visited, ocean);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> response = new ArrayList<>();
        int[][] visited = new int[heights.length][heights[0].length];

        for (int row = 0; row < heights.length; row++) {
            for (int col = 0; col < heights[0].length; col++) {
                if (row == 0 || col == 0) {
                    walk(heights, row, col, visited, PACIFIC);
                }
            }
        }

        for (int row = heights.length - 1; row >= 0; row--) {
            for (int col = heights[0].length - 1; col >= 0; col--) {
                if (row == heights.length - 1 || col == heights[0].length - 1) {
                    walk(heights, row, col, visited, ATLANTIC);
                }
            }
        }

        for (int row = 0; row < heights.length; row++) {
            for (int col = 0; col < heights[0].length; col++) {
                if (visited[row][col] == BOTH) {
                    response.add(List.of(row, col));
                }
            }
        }

        return response;
    }
}
