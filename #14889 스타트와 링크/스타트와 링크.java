import java.io.*;
import java.util.*;

public class Main {
    public static int[][] people;
    public static int MIN = Integer.MAX_VALUE;
    public static int N;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(MIN);
    }

    public static void dfs(int idx, int count) {
        if (count == N / 2) {
            different();
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    public static void different() {
        int TeamStart = 0;
        int TeamLink = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    TeamStart += people[i][j];
                    TeamStart += people[j][i];
                } else if (!visit[i] && !visit[j]) {
                    TeamLink += people[i][j];
                    TeamLink += people[j][i];
                }
            }
        }
        MIN = Math.min(MIN, Math.abs(TeamLink - TeamStart));
    }
}