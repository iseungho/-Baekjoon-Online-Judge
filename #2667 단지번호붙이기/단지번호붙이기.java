

import java.io.*;
import java.util.*;

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {

    public static int n;
    public static int[][] arr;
    public static boolean[][] visited;

    public static int bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r, c));
        visited[r][c] = true;

        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};
        int size = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if (isValid(nr, nc) && arr[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc));
                }
            }
        }
        return size;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int componentCount = 0;
        List<Integer> componentSizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    componentSizes.add(bfs(i, j));
                    componentCount++;
                }
            }
        }

        Collections.sort(componentSizes);

        StringBuilder sb = new StringBuilder();
        sb.append(componentCount).append("\n");
        for (int i = 0; i < componentSizes.size(); i++) {
            sb.append(componentSizes.get(i));
            if (i < componentSizes.size() - 1) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
