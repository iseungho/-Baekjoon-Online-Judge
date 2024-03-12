import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;;
    public static int[] S;
    public static int k;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            S = new int[k];
            visit = new boolean[k];
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            if (k == 0) {
                break;
            }
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth, int idx) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = S[i];
                dfs(depth + 1, i);
                visit[i] = false;
            }

        }
    }
}