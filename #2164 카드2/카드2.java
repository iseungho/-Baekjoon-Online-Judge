import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (true){
            if(q.size() == 1){
                System.out.println(q.peek());
                break;
            }
            q.poll();
            q.offer(q.poll());
        }
    }
}