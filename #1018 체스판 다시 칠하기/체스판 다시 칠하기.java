import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] Borad = new String[N];
        int result = 32;
        for (int i = 0; i < N; i++) {
            Borad[i] = br.readLine();
        }
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int temp = Search(i, j, Borad);
                if (result > temp) {
                    result = temp;
                }
            }
        }
        System.out.println(result);
    }

    public static int Search(int x, int y, String[] Borad) {
        String CompBorad[] = { "BWBWBWBW", "WBWBWBWB" };
        int temp = 0;
        for (int i = 0; i < 8; i++) {
            int n = x + i;
            for (int j = 0; j < 8; j++) {
                int m = y + j;
                if (Borad[n].charAt(m) == CompBorad[i % 2].charAt(j)) {
                    temp++;
                }
            }
        }
        return Math.min(temp, 64 - temp);
    }
}