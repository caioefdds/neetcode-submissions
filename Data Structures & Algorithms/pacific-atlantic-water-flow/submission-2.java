class Solution {
    private int[][] DIRECTIONS = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    private int PACIFIC = 1;
    private int ATLANTIC = 2;
    private int BOTH = 3;
    private void dfs(int[][] heights, int ocean, int row, int col, int[][] visited) {
        if ((visited[row][col] & ocean) != 0) return;

        visited[row][col] |= ocean;

        for (int[] direction : DIRECTIONS) {
            int nRow = row + direction[0];
            int nCol = col + direction[1];

            if (
                nRow < 0 ||
                nCol < 0 ||
                nRow >= heights.length ||
                nCol >= heights[0].length ||
                heights[nRow][nCol] < heights[row][col] ||
                ((visited[nRow][nCol] & ocean) != 0)
            ) continue;

            dfs(heights, ocean, nRow, nCol, visited);
        }


    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] visited = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            dfs(heights, PACIFIC, row, 0, visited);
            dfs(heights, ATLANTIC, row, cols - 1, visited);
        }

        for (int col = 0; col < cols; col++) {
            dfs(heights, PACIFIC, 0, col, visited);
            dfs(heights, ATLANTIC, rows - 1, col, visited);
        }

        System.out.println(Arrays.deepToString(visited));

        List<List<Integer>> response = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (visited[row][col] == BOTH) {
                    response.add(List.of(row, col));
                }
            }
        }

        return response;
    }
}
