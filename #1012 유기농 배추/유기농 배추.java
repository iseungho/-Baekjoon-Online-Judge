
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

    public static int n, m;
    public static int cnt;
    public static int[][] arr;

    public static void bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r, c));

        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if (isValid(nr, nc) && arr[nr][nc] == 1) {
                    arr[nr][nc] = 0;
                    queue.offer(new Point(nr, nc));
                }
            }
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); //가로
            n = Integer.parseInt(st.nextToken()); //세로
            int k = Integer.parseInt(st.nextToken()); //총 개수

            arr = new int[m][n];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[r][c] = 1;
            }

            cnt = 0;
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (arr[j][l] == 1) {
                        bfs(j, l);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
