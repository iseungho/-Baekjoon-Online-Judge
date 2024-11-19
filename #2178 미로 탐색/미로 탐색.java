import java.io.*;
import java.util.*;

class Point{
    int r,c;
    Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int m;

    static void bfs(int r, int c){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(r,c));

        int []dr={-1, 1, 0 , 0};
        int []dc={0, 0, -1, 1};

        while (!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isValid(nr, nc) && !visited[nr][nc] && arr[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    arr[nr][nc] = arr[p.r][p.c] + 1;
                    q.offer(new Point(nr, nc));
                }
            }
        }
    }
    public static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        bfs(0,0);

        System.out.println(arr[n-1][m-1]);
    }
}
