import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int King = Integer.parseInt(st.nextToken());
        int Queen = Integer.parseInt(st.nextToken());
        int Look = Integer.parseInt(st.nextToken());
        int Bishop = Integer.parseInt(st.nextToken());
        int Night = Integer.parseInt(st.nextToken());
        int Porn = Integer.parseInt(st.nextToken());
        System.out.println((1 - King) + " " + (1 - Queen) + " " + (2 - Look) + " " + (2 - Bishop) + " " + (2 - Night)
                + " " + (8 - Porn));
    }
}
