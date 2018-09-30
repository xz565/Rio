package union.find;

public class NumberOfIslands_200 {

    // Search & Union Find
    // DFS or BFS
    public static int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfsMarking(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfsMarking(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        if (grid[i][j] == '1') {
            dfsMarking(grid, visited, i + 1, j); // DOWN
            dfsMarking(grid, visited, i, j + 1); // RIGHT
            dfsMarking(grid, visited, i, j - 1); // LEFT
            dfsMarking(grid, visited, i - 1, j); // UP
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}}));
        System.out.println(numIslands(new char[][] {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}}));
    }
}
