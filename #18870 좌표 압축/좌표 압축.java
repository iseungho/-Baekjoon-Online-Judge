import java.io.*;
import java.util.*;

class point implements Comparable<point> {
    int num, idx;

    public point(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(point o) {
        return num - o.num;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        point[] arr = new point[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = new point(Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(arr);
        int min = arr[0].num, cnt = 0;
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            if (arr[i].num > min) {
                result[arr[i].idx] = ++cnt;
                min = arr[i].num;
            } else {
                result[arr[i].idx] = cnt;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
