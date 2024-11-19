import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0){
                stack.pop();
            }else{
                stack.push(n);
            }
        }
        while (!stack.isEmpty()){
            count += stack.pop();
        }
        System.out.println(count);
    }
}