import java.io.*;
import java.util.*;

public class Main {
    static int count1 = 0;
    static int count2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sb.readLine());
        refib(N);
        System.out.println(count1 + 1);
        dyfib(N);
        System.out.println(count2);
    }

    public static int refib(int N) {
        if (N == 1 || N == 2) {
            return 1;
        } else {
            count1++;
            return refib(N - 1) - refib(N - 2);
        }
    }

    public static int dyfib(int N) {
        int[] dyfib = new int[N + 1];
        dyfib[0] = 0;
        dyfib[1] = 1;
        for (int i = 2; i < N; i++) {
            dyfib[i] = dyfib[i - 1] + dyfib[i - 2];
            count2++;
        }
        return dyfib[N];
    }
}