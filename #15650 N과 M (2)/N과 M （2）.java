import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];
        dfs(0, 0);
        System.out.print(sb);
    }

    public static void dfs(int idx, int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}