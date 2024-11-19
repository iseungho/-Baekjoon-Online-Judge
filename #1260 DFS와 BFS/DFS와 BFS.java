import java.util.*;
import java.io.*;


class Point{
    int x;
    List<Point> list = new ArrayList<Point>();
    Point(int x){
        this.x = x;
    }
}
public class Main {

    public static Point[] arr;
    public static boolean[] visited;

    public static void bfs(int start){
        Queue<Point> q = new LinkedList<Point>();
        q.offer(arr[start]);
        visited[start] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            System.out.print(p.x +" ");

            for (Point next : p.list) {
                if(!visited[next.x]){
                    visited[next.x] = true;
                    q.offer(next);
                }
                
            }
        }
    }

    public static void dfs(int node){
        visited[node] = true;
        System.out.print(node+" ");

        for(Point next : arr[node].list){
            if(!visited[next.x]){
                dfs(next.x);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        arr = new Point[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new Point(i);
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].list.add(arr[end]);
            arr[end].list.add(arr[start]);
        }
        for (int i = 1; i <= n; i++) {
            arr[i].list.sort(Comparator.comparing(a -> a.x));
        }
        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);
    }
}
