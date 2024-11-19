import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            switch (x){
                case(1):
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case(2):
                    if(!stack.isEmpty()){
                        sb.append(stack.pop()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case(3):
                    sb.append(stack.size()).append("\n");
                    break;
                case(4):
                    if (!stack.isEmpty()){
                        sb.append(0).append("\n");
                    }else{
                        sb.append(1).append("\n");
                    }
                    break;
                case(5):
                    if(!stack.isEmpty()){
                        sb.append(stack.peek()).append("\n");
                    } else{
                        sb.append(-1).append("\n");
                    }
            }
        }
        System.out.println(sb);
    }
}