package company.gg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestPathWithSameValue {

//    private static int MAX = 0;

    public static int longestPathWithSameValue(int[] A, int[] E) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= A.length; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E.length; i++) {
            graph.get(E[i]).add(E[i + 1]);
            graph.get(E[i + 1]).add(E[i]);
            i++;
        }

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> nodeMax = new HashMap<>();
        int[] max = new int[1];
        for (int i = 1; i <= A.length; i++) {
            dfs(A, i, graph, visited, nodeMax, max);
        }

        return max[0] - 1;
    }

    private static void dfs(int[] A, int curtNode, Map<Integer, List<Integer>> graph, Set<Integer> visited,
                     Map<Integer, Integer> nodeMax, int[] max) {
        if (visited.contains(curtNode)) {
            return;
        }

        // mark current node as visited
        visited.add(curtNode);
        for (int neighbor : graph.get(curtNode)) {
            if (!visited.contains(neighbor) && A[curtNode - 1] == A[neighbor - 1]) {
                // dfs neighbor
                dfs(A, neighbor, graph, visited, nodeMax, max);
            }
        }

        // find longest two neighbors
        int largest = 0;
        int secondLargest = 0;

//        System.out.println(nodeMax);

        for (int neighbor : graph.get(curtNode)) {
//            System.out.println("neighbor: " + neighbor);
            if (A[curtNode - 1] == A[neighbor - 1] && nodeMax.containsKey(neighbor)) {
                int val = nodeMax.get(neighbor);
                if (val > largest) {
                    secondLargest = largest;
                    largest = val;
                } else if (val > secondLargest) {
                    secondLargest = val;
                }
            }
        }

//        System.out.println(largest + " " + secondLargest);

        if (largest + secondLargest + 1 > max[0]) {
            max[0] = largest + secondLargest + 1;
        }

        nodeMax.put(curtNode, largest + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPathWithSameValue(new int[] {1,1,1,1,1,1,1,1},
                new int[] {1,2,1,3,2,4,2,5,3,6,3,7,7,8}));
    }

}
