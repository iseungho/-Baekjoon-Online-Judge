import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String culgen = st.nextToken();
            if (culgen.equals("enter")){
                set.add(name);
            }else if (culgen.equals("leave")){
                set.remove(name);
            }
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
