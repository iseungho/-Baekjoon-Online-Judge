import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String[] arr = new String[t];
        for (int i = 0; i < t; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < arr.length; i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == '('){
                    stack.push('(');
                }
                else{
                    if (!stack.isEmpty() && '(' == stack.peek()){
                        stack.pop();
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && stack.isEmpty()){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }

        }
        System.out.println(sb);
    }
}