import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                q.add(x);
            } else if (str.equals("pop")){
                if(!q.isEmpty()){
                    sb.append(q.remove()).append("\n");
                }else {
                    sb.append(-1).append("\n");
                }
            } else if (str.equals("size")){
                sb.append(q.size()).append("\n");
            } else if (str.equals("empty")){
                if (q.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (str.equals("front")){
                if (q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.peek()).append("\n");
            } else if (str.equals("back")) {
                if (q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.getLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
