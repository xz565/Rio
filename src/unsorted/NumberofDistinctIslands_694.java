package unsorted;

import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands_694 {


    // The key to the solution is to find a way to represent the distinct shape.

    public static int numDistinctIslands(char[][] grid) {

        if (grid.length == 0) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> allShape = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    StringBuilder shape = new StringBuilder();
                    dfsMarking(grid, visited, i, j, shape);
                    allShape.add(shape.toString());
                }
            }
        }
        System.out.println(allShape);
        return allShape.size();
    }

    private static void dfsMarking(char[][] grid, boolean[][] visited, int i, int j, StringBuilder shape) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;

        dfsMarking(grid, visited, i + 1, j, shape.append("D")); // DOWN
        dfsMarking(grid, visited, i, j + 1, shape.append("R")); // RIGHT
        dfsMarking(grid, visited, i, j - 1, shape.append("L")); // LEFT
        dfsMarking(grid, visited, i - 1, j, shape.append("U")); // UP
    }

    public static void main(String[] args) {
        System.out.println(numDistinctIslands(new char[][] {
                {'1','1','0','1','1'},
                {'1','1','0','1','1'},
                {'1','1','0','1','1'},
                {'0','0','0','0','0'}}));
    }

}
