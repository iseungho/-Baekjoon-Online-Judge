import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] A = new String[N];
        String[] B = { "BWBWBWBW", "WBWBWBWB" };

        int count = 0;
        int r = 0;
        int sum = 64;

        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                for (int k = 0; k < 8; k++) {

                    for (int l = 0; l < 8; l++) {
                        if (A[k + i].charAt(l + j) == B[k % 2].charAt(l)) {
                            count++;
                        }
                    }
                }
                r = Math.min(count, 64 - count);
                count = 0;
                if (r < sum) {
                    sum = r;
                }
                r = 0;
            }
        }
        System.out.println(sum);
    }
}