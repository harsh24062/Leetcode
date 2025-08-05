import java.util.*;

class Solution {
    int[] segTree;

    private void constructTree(int[] baskets, int st, int end, int node) {
        if (st == end) {
            segTree[node] = baskets[st];
            return;
        }

        int mid = (st + end) / 2;
        constructTree(baskets, st, mid, 2 * node);
        constructTree(baskets, mid + 1, end, 2 * node + 1);
        segTree[node] = Math.max(segTree[2 * node], segTree[2 * node + 1]);
    }

    private int search(int node, int st, int end, int k) {
        if (segTree[node] < k) return -1;

        if (st == end) {
            segTree[node] = -1; // mark as used
            return st;
        }

        int mid = (st + end) / 2;
        int pos;
        if (segTree[2 * node] >= k) {
            pos = search(2 * node, st, mid, k);
        } else {
            pos = search(2 * node + 1, mid + 1, end, k);
        }

        segTree[node] = Math.max(segTree[2 * node], segTree[2 * node + 1]);
        return pos;
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        segTree = new int[4 * n];
        constructTree(baskets, 0, n - 1, 1);

        int unplaced = 0;
        for (int fruit : fruits) {
            if (search(1, 0, n - 1, fruit) == -1) {
                unplaced++;
            }
        }

        return unplaced;
    }
}
