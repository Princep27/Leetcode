import java.util.*;

class Solution {

    class SegNode {
        int mini, maxi;
        SegNode(int mini, int maxi) {
            this.mini = mini;
            this.maxi = maxi;
        }
    }

    private SegNode[] seg;

    private void build(int[] arr, int l, int r, int i) {
        if (l == r) {
            seg[i] = new SegNode(arr[l], arr[l]);
            return;
        }

        int mid = (l + r) / 2;
        build(arr, l, mid, i * 2 + 1);
        build(arr, mid + 1, r, i * 2 + 2);

        seg[i] = new SegNode(
            Math.min(seg[i * 2 + 1].mini, seg[i * 2 + 2].mini),
            Math.max(seg[i * 2 + 1].maxi, seg[i * 2 + 2].maxi)
        );
    }

    private SegNode query(int ql, int qr, int l, int r, int i) {

        if (r < ql || l > qr) {
            return new SegNode(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        if (ql <= l && r <= qr) {
            return seg[i];
        }

        int mid = (l + r) / 2;

        SegNode left = query(ql, qr, l, mid, i * 2 + 1);
        SegNode right = query(ql, qr, mid + 1, r, i * 2 + 2);

        return new SegNode(
            Math.min(left.mini, right.mini),
            Math.max(left.maxi, right.maxi)
        );
    }

    class Node {
        int diff, l, r;
        Node(int diff, int l, int r) {
            this.diff = diff;
            this.l = l;
            this.r = r;
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        seg = new SegNode[4 * n];
        build(nums, 0, n - 1, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.diff - a.diff);

        for (int i = 0; i < n; i++) {
            SegNode cur = query(i, n - 1, 0, n - 1, 0);
            pq.add(new Node(cur.maxi - cur.mini, i, n - 1));
        }

        long ans = 0;

        for (int t = 0; t < k && !pq.isEmpty(); t++) {
            Node cur = pq.poll();
            ans += cur.diff;

            if (cur.r - 1 >= cur.l) {
                SegNode nxt = query(cur.l, cur.r - 1, 0, n - 1, 0);
                pq.add(new Node(nxt.maxi - nxt.mini, cur.l, cur.r - 1));
            }
        }

        return ans;
    }
}