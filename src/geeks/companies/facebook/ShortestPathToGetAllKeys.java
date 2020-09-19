package geeks.companies.facebook;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class ShortestPathToGetAllKeys {
    int INF = Integer.MAX_VALUE;
    String[] grid;
    int R, C;
    Map<Character, Point> location;
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int shortestPathAllKeys(final String[] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length();

        //location['a'] = the coordinates of 'a' on the grid, etc.
        location = new HashMap();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                final char v = grid[r].charAt(c);
                if (v != '.' && v != '#')
                    location.put(v, new Point(r, c));
            }
        //Location is the place of @.

        int ans = INF;
        final int num_keys = location.size() / 2;
        final String[] alphabet = new String[num_keys];
        for (int i = 0; i < num_keys; ++i)
            alphabet[i] = Character.toString((char)('a' + i));
        //alphabet = ["a", "b", "c"], if there were 3 keys

        search: for (final String cand: permutations(alphabet, 0, num_keys)) {
            //bns : the built candidate answer, consisting of the sum
            //of distances of the segments from '@' to cand[0] to cand[1] etc.
            int bns = 0;
            for (int i = 0; i < num_keys; ++i) {
                final char source = i > 0 ? cand.charAt(i-1) : '@';
                final char target = cand.charAt(i);

                //keymask : an integer with the 0-th bit set if we picked up
                // key 'a', the 1-th bit set if we picked up key 'b', etc.
                int keymask = 0;
                for (int j = 0; j < i; ++j)
                    keymask |= 1 << (cand.charAt(j) - 'a');
                final int d = bfs(source, target, keymask);
                if (d == INF) continue search;
                bns += d;
                if (bns >= ans) continue search;
            }
            ans = bns;
        }

        return ans < INF ? ans : -1;
    }

    public int bfs(final char source, final char target, final int keymask) {
        final int sr = location.get(source).x;
        final int sc = location.get(source).y;
        final int tr = location.get(target).x;
        final int tc = location.get(target).y;
        final boolean[][] seen = new boolean[R][C];
        seen[sr][sc] = true;
        int curDepth = 0;
        final Queue<Point> queue = new LinkedList();
        queue.offer(new Point(sr, sc));
        queue.offer(null);

        while (!queue.isEmpty()) {
            final Point p = queue.poll();
            if (p == null) {
                curDepth++;
                if (!queue.isEmpty())
                    queue.offer(null);
                continue;
            }
            final int r = p.x;
            final int c = p.y;
            if (r == tr && c == tc) return curDepth;
            for (int i = 0; i < 4; ++i) {
                final int cr = r + dr[i];
                final int cc = c + dc[i];
                if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                    final char cur = grid[cr].charAt(cc);
                    if (cur != '#') {
                        if (Character.isUpperCase(cur) && (((1 << (cur - 'A')) & keymask) <= 0))
                            continue; // at lock and don't have key

                        queue.offer(new Point(cr, cc));
                        seen[cr][cc] = true;
                    }
                }
            }
        }

        return INF;
    }

    public List<String> permutations(final String[] alphabet, final int used, final int size) {
        final List<String> ans = new ArrayList();
        if (size == 0) {
            ans.add(new String(""));
            return ans;
        }

        for (int b = 0; b < alphabet.length; ++b)
            if (((used >> b) & 1) == 0)
                for (final String rest: permutations(alphabet, used | (1 << b), size - 1))
                    ans.add(alphabet[b] + rest);
        return ans;
    }
}
