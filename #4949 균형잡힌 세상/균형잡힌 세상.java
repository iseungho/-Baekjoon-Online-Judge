import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true){
            String str = br.readLine();
            if (str.equals(".")){
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(ch == '(' || ch == ')' || ch == '[' || ch == ']'){
                    if (ch == '(' || ch == '['){
                        stack.push(ch);
                    }
                    else{
                        if (!stack.isEmpty()){
                            if(('(' == stack.peek() && ch == ')')||('[' == stack.peek() && ch == ']'))
                                stack.pop();
                            else {
                                flag = false;
                                break;
                            }
                        }
                        else{
                            flag = false;
                            break;
                        }
                    }
                }

            }
            if (flag && stack.isEmpty()){
                sb.append("yes").append("\n");
            }else{
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}
