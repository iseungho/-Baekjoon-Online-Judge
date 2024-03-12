import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr = new int[9][9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
    }

    public static void dfs(int depth, int idx) {
        if (idx == 9) {
            dfs(depth + 1, 0);
            return;
        }
        if (depth == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        if (arr[depth][idx] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (Sudoku(depth, idx, i)) {
                    arr[depth][idx] = i;
                    dfs(depth, idx + 1);
                }
            }
            arr[depth][idx] = 0;
            return;
        }
        dfs(depth, idx + 1);
    }

    public static boolean Sudoku(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == value) {
                return false;
            }
            if (arr[i][y] == value) {
                return false;
            }
        }
        int r = (x / 3) * 3, c = (y / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}