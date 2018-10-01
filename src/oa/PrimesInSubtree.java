package oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimesInSubtree {


    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }


    public static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second,
                                   List<Integer> values, List<Integer> queries) {

        List<Integer> rst = new ArrayList<>();

        // create nodes
        TreeNode[] treeNodes = new TreeNode[n+1];
        for (int i = 1; i <= n; i++) {
            treeNodes[i] = new PrimesInSubtree.TreeNode(values.get(i-1), i);
        }

        // add connection
        for (int i = 0; i < first.size(); i++) {
            treeNodes[first.get(i)].children.add(treeNodes[second.get(i)]);
            treeNodes[second.get(i)].children.add(treeNodes[first.get(i)]);
        }

        // count primes in subtree
//        countPrimes(treeNodes[1]);

        // query
        for (int i = 0; i < queries.size(); i++) {
            boolean[] visited = new boolean[n];
            rst.add(countPrimes(treeNodes[queries.get(i)], visited));
//            rst.add(treeNodes[queries.get(i)].numberOfPrimesInSubtree);
        }

        return rst;
    }

    private static int countPrimes(TreeNode treeNode, boolean[] visited) {
        // leaf node
//        if (treeNodes[curtNode].children.isEmpty()) {
//            return 0;
//        }
        if (visited[treeNode.nodeNumber - 1]) return 0;
        visited[treeNode.nodeNumber - 1] = true;

        int count = 0;
        for (TreeNode child : treeNode.children) {
            count += countPrimes(child, visited);
        }


        if (isPrime(treeNode.data)) {
            count += 1;
        }
        treeNode.numberOfPrimesInSubtree = count;
        return count;
    }

    public static void main(String[] args) {
        List<Integer> ans = primeQuery(6, Arrays.asList(1,1,2,2,3), Arrays.asList(2,3,4,5,6),
                Arrays.asList(2,2,6,5,4,3), Arrays.asList(1,4,5,6,2));
        System.out.println(ans);

        ans = primeQuery(10, Arrays.asList(6,8,3 ,6 ,4 ,1 ,8 ,5 ,1), Arrays.asList(9 ,9 ,5 ,7 ,8 ,8 ,10 ,8 ,2),
                Arrays.asList(17 ,29 ,3 ,20 ,11 ,8 ,3 ,23 ,5 ,15), Arrays.asList(1 ,8 ,9 ,6 ,4 ,3));
        System.out.println(ans);
    }

    static class TreeNode {
        int data;
        int nodeNumber;
        List<TreeNode> children;
        int numberOfPrimesInSubtree;

        public TreeNode(int data, int number) {
            this.data = data;
            this.nodeNumber = number;
            children = new ArrayList<>();
        }
    }
}
