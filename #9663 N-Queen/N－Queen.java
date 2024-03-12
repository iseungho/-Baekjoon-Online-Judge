import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        queen(0);
        System.out.print(count);
    }

    public static void queen(int depth) {

        if (depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (possible(depth)) {
                queen(depth + 1);
            }

        }
    }

    public static boolean possible(int search) {
        for (int i = 0; i < search; i++) {
            if (arr[search] == arr[i]) {
                return false;
            } else if (Math.abs(search - i) == Math.abs(arr[search] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}