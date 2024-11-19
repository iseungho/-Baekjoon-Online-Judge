import java.io.*;
import java.util.*;

class Point{
    int x;
    List<Point> list = new ArrayList<>();
    public Point(int x){
        this.x = x;
    }
}

public class Main {
    public static int count;
    public static int n;
    public static Point[] arr;
    public static boolean[] visited;

    public static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.offer(arr[1]);
        visited[1] = true;
        count = 0;
        while (!q.isEmpty()){
            Point start = q.poll();
            for (Point end : start.list){
                if (!visited[end.x]){
                    visited[end.x] = true;
                    q.offer(end);
                    count++;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        arr = new Point[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new Point(i);
        }

        int line = Integer.parseInt(br.readLine());
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].list.add(arr[end]);
            arr[end].list.add(arr[start]);
        }
        bfs();
        System.out.println(count);
    }
}
