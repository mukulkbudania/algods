package geeks.companies.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReachableComponents {
    public int reachableNodes(final int[][] edges, final int M, final int N) {
        final Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for (final int[] edge: edges) {
            final int u = edge[0];
            final int v = edge[1];
            final int w = edge[2];
            graph.computeIfAbsent(u, x->new HashMap()).put(v, w);
            graph.computeIfAbsent(v, x->new HashMap()).put(u, w);
        }

        final PriorityQueue<ANode> pq = new PriorityQueue<ANode>(
            (a, b) -> Integer.compare(a.dist, b.dist));
        pq.offer(new ANode(0, 0));

        final Map<Integer, Integer> dist = new HashMap();
        dist.put(0, 0);
        final Map<Integer, Integer> used = new HashMap();
        int ans = 0;

        while (!pq.isEmpty()) {
            final ANode anode = pq.poll();
            final int node = anode.node;
            final int d = anode.dist;

            if (d > dist.getOrDefault(node, 0)) continue;
            // Each node is only visited once.  We've reached
            // a node in our original graph.
            ans++;

            if (!graph.containsKey(node)) continue;
            for (final int nei: graph.get(node).keySet()) {
                // M - d is how much further we can walk from this node;
                // weight is how many new nodes there are on this edge.
                // v is the maximum utilization of this edge.
                final int weight = graph.get(node).get(nei);
                final int v = Math.min(weight, M - d);
                used.put(N * node + nei, v);

                // d2 is the total distance to reach 'nei' (neighbor) node
                // in the original graph.
                final int d2 = d + weight + 1;
                if (d2 < dist.getOrDefault(nei, M+1)) {
                    pq.offer(new ANode(nei, d2));
                    dist.put(nei, d2);
                }
            }
        }

        // At the end, each edge (u, v, w) can be used with a maximum
        // of w new nodes: a max of used[u, v] nodes from one side,
        // and used[v, u] nodes from the other.
        // [We use the encoding (u, v) = u * N + v.]
        for (final int[] edge: edges) {
            ans += Math.min(edge[2], used.getOrDefault(edge[0] * N + edge[1], 0) +
                used.getOrDefault(edge[1] * N + edge[0], 0) );
        }

        return ans;
    }
}

class ANode {
    int node, dist;
    ANode(final int n, final int d) {
        node = n;
        dist = d;
    }
}